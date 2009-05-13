package com.baosight.mode;

public class DBSY implements java.io.Serializable {

	private String userId;

	private String userName;

	private String userAcc;

	private String roleId;

	private String roleName;

	private String roleCode;

	private Long roleInsure;

	private String funId;

	private String funKey;

	private String funName;

	private String funUrl;

	private String funSys;

	private String funParId;

	private Long funInsure;

	private String funRightTypeId;

	public DBSY() {

	}

	public DBSY(String userId, String userName, String userAcc, String roleId,
			String roleName, String roleCode, Long roleInsure, String funId,
			String funKey, String funName, String funUrl, String funSys,
			String funParId, Long funInsure, String funRightTypeId) {
		this.userId = userId;
		this.userName = userName;
		this.userAcc = userAcc;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.roleInsure = roleInsure;
		this.funId = funId;
		this.funKey = funKey;
		this.funName = funName;
		this.funUrl = funUrl;
		this.funSys = funSys;
		this.funParId = funParId;
		this.funInsure = funInsure;
		this.funRightTypeId = funRightTypeId;
	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}

	public Long getFunInsure() {
		return funInsure;
	}

	public void setFunInsure(Long funInsure) {
		this.funInsure = funInsure;
	}

	public String getFunKey() {
		return funKey;
	}

	public void setFunKey(String funKey) {
		this.funKey = funKey;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getFunParId() {
		return funParId;
	}

	public void setFunParId(String funParId) {
		this.funParId = funParId;
	}

	public String getFunRightTypeId() {
		return funRightTypeId;
	}

	public void setFunRightTypeId(String funRightTypeId) {
		this.funRightTypeId = funRightTypeId;
	}

	public String getFunSys() {
		return funSys;
	}

	public void setFunSys(String funSys) {
		this.funSys = funSys;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getRoleInsure() {
		return roleInsure;
	}

	public void setRoleInsure(Long roleInsure) {
		this.roleInsure = roleInsure;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserAcc() {
		return userAcc;
	}

	public void setUserAcc(String userAcc) {
		this.userAcc = userAcc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

}
