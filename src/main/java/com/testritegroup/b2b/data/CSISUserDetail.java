package com.testritegroup.b2b.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bnslink.base.dataobj.BlockDetail;
import com.bnslink.base.dataobj.FunctionDetail;
import com.bnslink.base.dataobj.MemberDetail;
import com.bnslink.base.dataobj.OrganizationDetail;
import com.bnslink.base.dataobj.UserDetail;

public class CSISUserDetail implements Serializable, UserDetails {
	
	

	private static final long serialVersionUID = 1L;
	private UserDetail userDetail;
	private MemberDetail memberDetail;
	private List<FunctionDetail> functions;
	private List<BlockDetail> blockFunctions;
	private OrganizationDetail userOrganization;
	private List<CSISRole> userRoles;
	
	public CSISUserDetail(UserDetail userDetail){
		this.userDetail = userDetail;
	}
	
	public OrganizationDetail getUserOrganization() {
		return userOrganization;
	}
	public void setUserOrganization(OrganizationDetail userOrganization) {
		this.userOrganization = userOrganization;
	}
	public List<BlockDetail> getBlockFunctions() {
		return blockFunctions;
	}
	public void setBlockFunctions(List<BlockDetail> blockFunctions) {
		this.blockFunctions = blockFunctions;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public MemberDetail getMemberDetail() {
		return memberDetail;
	}
	public void setMemberDetail(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}
	public List<FunctionDetail> getFunctions() {
		return functions;
	}
	public void setFunctions(List<FunctionDetail> functions) {
		this.functions = functions;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getUserRoles();
	}
	@Override
	public String getPassword() {
		return userDetail.getPassword();
	}
	@Override
	public String getUsername() {
		return userDetail.getAccount();
	}
	@Override
	public boolean isAccountNonExpired() {
		return !userDetail.getUsrStatus().equals(UserDetail.USER_STATUS_SUSPENDED);
	}
	@Override
	public boolean isAccountNonLocked() {
		return !userDetail.getUsrStatus().equals(UserDetail.USER_STATUS_LOCKED);
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return !userDetail.getUsrStatus().equals(UserDetail.USER_STATUS_SUSPENDED);
	}
	@Override
	public boolean isEnabled() {
		return userDetail.getUsrStatus().equals(UserDetail.USER_STATUS_ACTIVE);
	}
	public List<CSISRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<CSISRole> userRoles) {
		this.userRoles = userRoles;
	}
	
}
