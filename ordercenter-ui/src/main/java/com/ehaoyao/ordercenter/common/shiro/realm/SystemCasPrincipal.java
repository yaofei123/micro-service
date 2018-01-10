package com.ehaoyao.ordercenter.common.shiro.realm;

import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 存储用户数据
 * @author chenxiaoqin
 *
 */
public class SystemCasPrincipal extends com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal {

	private static final long serialVersionUID = -1715647945258717519L;

	public SystemCasPrincipal(User user, boolean mobileLogin) {
		super(user, mobileLogin);
	}
	
	private String officeId;
	private String phone;
	private String no;
	private String loginFlag;
	private String userType;
	private String loginIp;
	private String email;
	private String loginDate;
	private String companyId;
	private String mobile;
	
	private String shiro_permission;
	private String shiro_role;

	public SystemCasPrincipal(User user, boolean mobileLogin,
                              String id, String loginName, String name,
                              String officeId, String phone, String no, String loginFlag,
                              String userType, String loginIp, String email, String loginDate,
                              String companyId, String mobile, String shiro_permission,
                              String shiro_role) {
		super(user, mobileLogin);
		this.officeId = officeId;
		this.phone = phone;
		this.no = no;
		this.loginFlag = loginFlag;
		this.userType = userType;
		this.loginIp = loginIp;
		this.email = email;
		this.loginDate = loginDate;
		this.companyId = companyId;
		this.mobile = mobile;
		this.shiro_permission = shiro_permission;
		this.shiro_role = shiro_role;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getShiro_permission() {
		return shiro_permission;
	}

	public void setShiro_permission(String shiro_permission) {
		this.shiro_permission = shiro_permission;
	}

	public String getShiro_role() {
		return shiro_role;
	}

	public void setShiro_role(String shiro_role) {
		this.shiro_role = shiro_role;
	}
	
}
