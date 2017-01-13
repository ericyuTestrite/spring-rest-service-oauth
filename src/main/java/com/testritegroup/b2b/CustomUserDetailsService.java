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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bnslink.base.bean.WorkingEnvironment;
import com.bnslink.base.util.DigestUtil;
import com.testritegroup.b2b.data.CSISRole;
import com.testritegroup.b2b.data.CSISUserDetail;
import com.testritegroup.b2b.data.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private Logger logger = Logger.getLogger(CustomUserDetailsService.class);

	@Autowired
	public CustomUserDetailsService() {
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
			WorkingEnvironment we = new WorkingEnvironment();
			CSISUserDetail userInfo = null;
			try {
				String currenttime = String.valueOf(System.currentTimeMillis());
				String checkSum;
				checkSum = DigestUtil.getChecksum(username, currenttime);
				we.login2(username, currenttime, checkSum, "refreshTokenSession", "");
				String appCD = "B2B";

				userInfo = new CSISUserDetail(we.getUserInfo());
				userInfo.setMemberDetail(we.getMemberInfo());
				userInfo.setFunctions(we.getFunctions(appCD));
				we.getApplications();
				userInfo.setBlockFunctions(we.getBlocks(appCD));
				userInfo.setUserOrganization(we.getOrganizationInfo());
				//a default role
				List<CSISRole> userRoles = new ArrayList<CSISRole>();
				CSISRole role = new CSISRole();
				role.setRole("ROLE_USER");
				userRoles.add(role);
				userInfo.setUserRoles(userRoles);
			} catch (Exception e) {
				UsernameNotFoundException unfe = new UsernameNotFoundException(e.getMessage(),e);
				throw unfe;
			}
			return userInfo;
	}
}
