package com.lingnan.usersys.usermgr.business.service;

import com.lingnan.usersys.usermgr.domain.UserVO;

public interface UserService {
	/**
	 * 用户登录的方法
	 * @param username 用户名
	 * @param password 密码
	 * @return  登录成功返回用户信息 （UserVO对象），否则返回null
	 */
	public UserVO login(String username,String password);
}
