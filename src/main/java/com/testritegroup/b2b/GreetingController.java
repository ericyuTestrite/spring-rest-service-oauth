/*
 * Copyright 2014 the original author or authors.
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

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnslink.base.dataobj.UserDetail;
import com.testritegroup.b2b.data.CSISUserDetail;
import com.testritegroup.b2b.data.User;

@RestController
public class GreetingController {
	Logger logger = Logger.getLogger(GreetingController.class);

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@AuthenticationPrincipal CSISUserDetail user) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, user.getUserDetail().getAccount()));
	}
	
	@RequestMapping("/aboutMe")
	public UserDetail aboutMe(@AuthenticationPrincipal CSISUserDetail user) {
		return user.getUserDetail();
	}
	
	@RequestMapping("/hi")
	public String hi(@AuthenticationPrincipal User user) {
		logger.info(user.getId() + " calling Hi..");
		return "Hi "+ user.getLogin();
	}

}
