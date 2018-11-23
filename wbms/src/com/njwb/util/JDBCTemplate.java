package com.njwb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.njwb.rowmapper.RowMapper;

 

/**
 * JDBC模版工具类
 * @author ljd
 */
public class JDBCTemplate {
	/**
	 * 新增、修改、删除通用模版方法
	 * @param sql 预编译sql语句
	 * @param params 针对于sql所需要的数据
	 * @throws Exception 
	 */
	public Boolean update(String sql,Object ...params ) throws Exception{
		System.out.println(sql);
		//insert delete update
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//通过工具类获得连接对象
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			setParams(ps, params);
			//执行sql语句
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("数据库访问失败");
			e.printStackTrace();
			throw e;
		} finally{
			JDBCUtil.close(null, ps, null);
		}

	}
	
	/**
	 * 查询通用模版方法
	 * @param sql 预编译sql语句
	 * @param rm 具体根据所需要返回的对象传入对应的行映射实现类对象
	 * @param params 针对于sql所需要的数据 
	 * @return
	 * @throws Exception 
	 */
	public ResultSet query(String sql,Object ... params) throws Exception{
		// select
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=new ArrayList();
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			System.out.println("执行的sql:" + sql);
			setParams(ps, params);
			rs=ps.executeQuery();
		} catch (Exception e) {
			System.out.println("数据库访问失败");
			e.printStackTrace();
			throw e;
		} finally{
			JDBCUtil.close(null, ps, rs);
		}
		
		return rs;
	}
	
	
	public List query(String sql,RowMapper rm,Object ... params) throws Exception{
		// select
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list=new ArrayList();
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			System.out.println("执行的sql:" + sql);
			setParams(ps, params);
			rs=ps.executeQuery();
			while(rs.next()){
				//接收结果集返回的每一行数据
				Object o=rm.getMapRow(rs);
				list.add(o);
			}
			
		} catch (Exception e) {
			System.out.println("数据库访问失败");
			e.printStackTrace();
			throw e;
		} finally{
			JDBCUtil.close(null, ps, rs);
		}
		
		return list;
	}

	private void setParams(PreparedStatement ps, Object... params)
			throws SQLException {
		System.out.print("sql参数");
		for (int i = 0; i < params.length; i++) {
//				params(ps, params[i], i+1);
			ps.setObject(i+1, params[i]);
			System.out.print("," + params[i]);
		}
		//ps = 
		//打印jdbc执行的sql语句！！！！！
		System.out.println();
	}
	
	//针对于不同数据类型的数据进行类型转换处理
//	private void params(PreparedStatement ps,Object param,int index){
//		if(param instanceof String){
//			try {
//				ps.setString(index, (String)param);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}else if(param instanceof Date){
//			try {
//				ps.setDate(index, new java.sql.Date(((Date)param).getTime()));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	

}
