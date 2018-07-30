package com.lingnan.usersys.common.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DaoException;


/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DBUtils {
	/**
	 * 获取数据库连接的方法
	 * @return 返回获得的连接
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try{
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url= "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password="123456";
			//获得连接对象
			 conn = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
			//加载驱动失败
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}catch(SQLException e){
			//获取连接对象失败
			//e.printStackTrace();
			throw new DaoException("获取连接对象失败...", e);
		}
		return conn;
	}
	
	/**
	 * 开启事务的方法
	 * @param conn 
	 */
	public static void beginTransaction(Connection conn){
		try {
			//将事务的自动提交模式设为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// 事务开启失败
			//e.printStackTrace();
			throw new DaoException("事务开启失败...", e);
		}
	}
	
	/**
	 * 提交事务的方法
	 * @param conn
	 */
	public static void commit(Connection conn){
		try {
			//提交事务
			conn.commit();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// 事务提交失败
			//e.printStackTrace();
			throw new DaoException("事务提交失败...", e);
		}
	}
	
	/**
	 * 回滚事务的方法
	 * @param conn
	 */
	public static void rollback(Connection conn){
		try {
			//回滚事务
			conn.rollback();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// 事务回滚失败
			//e.printStackTrace();
			throw new DaoException("事务回滚失败...", e);
		}
	}
	
	/**
	 * 关闭连接对象的方法
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try {
			//如果数据库连接对象非空，关闭该对象
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// 关闭连接对象失败
			//e.printStackTrace();
			throw new DaoException("关闭连接对象失败...", e);
		}
	}
/**
 * 关闭结果集和声明对象的方法
 * @param rs
 * @param stmt
 */
	public static void closeStatement(ResultSet rs,Statement stmt){
		try {
			//如果查询结果集对象非空，关闭该对象
			if(rs != null){
				rs.close();
			}
			//如果声明对象非空，关闭该对象
			if (stmt != null) {
				stmt.close();
			}
			
		} catch (SQLException e) {
			// 关闭声明对象失败
			//e.printStackTrace();
			throw new DaoException("关闭声明对象失败...", e);
		}
	}
}
