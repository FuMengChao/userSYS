package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testLogin() {
		Connection conn = DBUtils.getConnection();
		UserDaoImpl up =new UserDaoImpl(conn);
		UserVO user = new UserVO();
		user = up.login("aaa","aaa");
		System.out.println(conn);
		System.out.println("登录的用户是："+user.getUsername());		
	}

}
