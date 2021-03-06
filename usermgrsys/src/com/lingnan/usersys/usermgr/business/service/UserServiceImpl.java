package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例化，在类的内部创建唯一的实例
	 */
	private static UserService userService=new UserServiceImpl();
	/**
	 * 构造方法私有化
	 */
	private UserServiceImpl(){
		
	}
	/**
	 * 取得用户userService实例
	 * @return 实例对象userService
	 */
	public static UserService getInstance(){
		return userService;
	}
	
	/**
	 * 用户登录的方法
	 * @param username 用户名
	 * @param password 密码
	 * @return  登录成功返回用户信息 （UserVO对象），否则返回null
	 */
	public UserVO login(String username, String password){
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明结果变量，用于保存查询结果
		UserVO user = null;
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法， 取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgroDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用dao中的login方法，进行登录操作，结果赋值给登录结果变量
			user = userMgroDao.login(username, password);
		} catch (DaoException e) {
			// 将异常封装成自定义异常并抛出
			throw e;
		}catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("用户登录失败", e);
		}finally{
			//释放资源/关闭数据库连接
			DBUtils.closeConnection(conn);
		}
		//返回用户登录的结果
		return user;
	}
	
}
