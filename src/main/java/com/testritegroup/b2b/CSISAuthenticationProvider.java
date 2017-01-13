package com.testritegroup.b2b;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.bnslink.base.bean.WorkingEnvironment;

@Component
public class CSISAuthenticationProvider implements AuthenticationProvider {
	Logger logger = Logger.getLogger(CSISAuthenticationProvider.class);
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
		try {
			WorkingEnvironment we = new WorkingEnvironment();
			String result = we.login(name, password, null, "getAccessTokenSession", null);
			
			if(result.equals("30100200")){
				//login passed
				logger.info("User "+ name+ " login successed (code: "+ result+")");
				return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
			}else{
				return null;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
