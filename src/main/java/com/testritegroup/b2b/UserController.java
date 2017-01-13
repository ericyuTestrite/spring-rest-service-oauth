/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.testritegroup.b2b;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnslink.base.bean.WorkingEnvironment;
import com.bnslink.base.dataobj.UserDetail;
import com.testritegroup.b2b.data.User;
import com.testritegroup.b2b.data.CSISUserDetail;
import com.testritegroup.b2b.data.UserRepository;

@RestController
public class UserController {

	private final UserRepository userRepository;
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/users")
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping("/aboutMe")
	public CSISUserDetail aboutMe(Principal user) {
		CSISUserDetail userDetails = (CSISUserDetail)userDetailsService.loadUserByUsername(user.getName());
		return userDetails;
	}
	
	@RequestMapping("/loginBnsbase")
	public CSISUserDetail loginBnsbase(HttpSession session){
		WorkingEnvironment we = new WorkingEnvironment();
		boolean isLogin = false;
		CSISUserDetail userInfo = null;
		try {
			String sessionId = session.getId();
			String result = we.login("3M", "1234", null, sessionId, null);
			logger.info("Login result "+ result);
			if(result.equals("30100200")){
				isLogin = true;
			}
			if(isLogin){
				String appCD = "TLW";
				userInfo = new CSISUserDetail(we.getUserInfo());
				userInfo.setMemberDetail(we.getMemberInfo());
				userInfo.setFunctions(we.getFunctions(appCD));
				we.getApplications();
				userInfo.setBlockFunctions(we.getBlocks(appCD));
				userInfo.setUserOrganization(we.getOrganizationInfo());
			}else{
				throw new AccessDeniedException("403 returned");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return userInfo;
	}

}
