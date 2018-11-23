package com.njwb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


/**
 * JDBC工具类
 * 
 * @author ljd
 * 
 */
public class JDBCUtil {
	private static DataSource ds;
	//用于存放一个线程中的Connection对象
	private static ThreadLocal<Connection> threadLocal;

	static {
		threadLocal=new ThreadLocal<Connection>();
		try {
			// 获得Properties对象用于加载datasource.properties配置文件
			Properties p = new Properties();
			// 通过当前类的加载器读取类加载路径下的datasource.properties配置文件
			p.load(JDBCUtil.class.getClassLoader().getResourceAsStream(
					"datasource.properties"));
			// 通过数据源工厂解析配置文件获得数据源
			ds = BasicDataSourceFactory.createDataSource(p);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("JDBCUtil初始化错误");
		}

	}

	/**
	 * 返回Connection对象
	 * 
	 * @return Connection 连接对象
	 * @throws SQLException 
	 */
//	一个事务一个连接	一个业务一个连接	一个线程一个连接
	public static Connection getConnection() throws SQLException {
		Connection con = threadLocal.get();//获得当前线程的Connection对象
		// 如果连接对象为空，通过数据源获得连接对象
		if (con == null) {
			try {
				con = ds.getConnection();
//				将当前对象放入threadLocal中
				threadLocal.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return con;
	}

	/**
	 * 用于对数据库进行关闭
	 * 
	 * @param Connection
	 * @param PreparedStatement
	 * @param ResultSet
	 */
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
				threadLocal.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭本线程中的Connection连接
	 */
	public static void close(){
		Connection con = threadLocal.get();//获得本线程的Connection对象
//		如果不为空
		if(con!=null){
			try {
				con.close();
				threadLocal.remove();//将本线程中的Connection对象进行删除
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
