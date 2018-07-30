package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用户dao接口的实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	/**
	 * 数据库连接
	 */
	private Connection conn;
	/**
	 * 构造方法
	 * @param conn 数据库连接
	 * @return 
	 */
	public  UserDaoImpl(Connection conn){
		//给属性赋初始值
		this.conn = conn;
	}
	
	/**
	 * 用户登录的方法
	 * @param user 用户对象
	 * @return 用户信息
	 */
	public UserVO login(String username,String password){
		//声明结果集对象变量，用于保存查询结果
		ResultSet rs = null;
		//声明预编译的对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVO user = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象。
			pstam = conn.prepareStatement
					("select * from UserInfo where username=? and password=? and status='0'");
			//调用预编译对象的setXxx方法，给？号赋值
			pstam.setString(1, username);
			pstam.setString(2, password);
			//执行查询操作，将查询结果赋值给结果集
			rs=pstam.executeQuery();
			//如果查询结果非空，取出结果集中的各个字段，封装在用户对象的各个属性中。
			if(rs.next()){
				//创建一个新的用户对象，赋值给用户对象
				user = new UserVO();
				/*
				 * 调用结果集的getXxx方法，取出各个字段的值，
				 * 然后调用用户对象的setXxx方法，给属性赋值，
				 * 最后新创建的对象中包含了查询结果中所有字段的值
				 */
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirth(rs.getDate("birth"));
				user.setUsertype(rs.getString("usertype"));
			}
		} catch (SQLException e) {
			System.out.println("用户登录时出错，错误信息是"+e.getMessage());
			// 将异常封装为自定义异常
			throw new DaoException("用户登录失败", e);
		} finally{
			//调用数据库工具类，关闭结果集和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
		/*
		 * 返回用户对象，如果非空，该对象中封装了查询的数据
		 * 如果为空，返回空值null
		 */
		return user;
		
	}
	
//	public boolean addUser(UserVO user){
//		
//	}
}
