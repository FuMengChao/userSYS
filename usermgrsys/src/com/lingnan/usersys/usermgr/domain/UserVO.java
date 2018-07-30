package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

/**
 * 用户信息类
 * @author Administrator
 *
 */
public class UserVO {
	private int id; 		  //主键(用户编号)
	private String username;  //用户名
	private String password;  //密码
	private String email;	  //邮箱
	private Date birth;		  //出生日期
	private String usertype;  //用户类型
	private String status;    //状态
	
	/**
	 * 取得用户编号
	 * @return 用户编号
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置传递id值的方法
	 * @param id 传递id的值
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 取得用户名
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置传递username值方法
	 * @param username 传递username的值
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 取得密码
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置传递password值的方法
	 * @param password 传递password的值
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 取得邮箱
	 * @return 邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置传递email值的方法
	 * @param email 传递email的值
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 取得出生日期
	 * @return 出生日期
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置传递birth值的方法
	 * @param birth 传递birth的值
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * 取得用户类型
	 * @return 用户类型
	 */
	public String getUsertype() {
		return usertype;
	}
	/**
	 * 设置传递usertype值的方法
	 * @param usertype 传递usertype的值
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	/**
	 * 取得状态
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置传递status值的方法
	 * @param status 传递status的值
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
