package com.testritegroup.b2b.data;

import org.springframework.security.core.GrantedAuthority;

public class CSISRole implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return getRole();
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String role;

}
