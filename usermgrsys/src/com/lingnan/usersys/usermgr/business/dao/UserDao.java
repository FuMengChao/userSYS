package com.lingnan.usersys.usermgr.business.dao;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

public interface UserDao extends BaseDao{
	
	/**
	 * 用户登录的方法
	 * @param username 用户名
	 * @param password 密码
	 * @return  登录成功返回用户信息 （UserVO对象），否则返回null
	 */
	public UserVO login(String username,String password);
	/**
	 * 添加用户/用户注册的方法
	 * @param user 用户信息
	 * @return
	 */
//	public boolean addUser(UserVO user);
	
}
