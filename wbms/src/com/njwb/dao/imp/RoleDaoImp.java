package com.njwb.dao.imp;

import java.util.List;

import com.njwb.dao.RoleDao;
import com.njwb.entity.Role;
import com.njwb.rowmapper.imp.AccessMenuIdRowMapper;
import com.njwb.rowmapper.imp.RoleRowMapper;
import com.njwb.util.JDBCTemplate;

public class RoleDaoImp implements RoleDao {
	JDBCTemplate jt = new JDBCTemplate();

	public List<Role> queryAllRole() {
		String sql = "select * from t_role";
		try {
			List<Role> roleList = jt.query(sql, new RoleRowMapper());
			return roleList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean roleAdd(String roleName) {
		// 添加角色后要在菜单-用户表中添加角色对应顶的菜单
		String sql1 = "insert into t_role (role_name, role_create_time) values(?, now())";

		String sql2 = "insert into t_menu_role values "
				+ " (1, ( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(2, ( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(3, ( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(11,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(12,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(13,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(21,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(22,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(31,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(32,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(33,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(34,( select role_id from t_role where role_name = ?),-1,now())"
				+ ",(35,( select role_id from t_role where role_name = ?),-1,now()) ";

		try {
			boolean b1 = jt.update(sql1, roleName);

			boolean b2 = jt.update(sql2, roleName, roleName, roleName,
					roleName, roleName, roleName, roleName, roleName, roleName,
					roleName, roleName, roleName, roleName);

			return b1 && b2;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean roleDelete(Integer roleId) {
		// 删除角色后要同时删除菜单角色表
		String sql1 = "delete from t_role where role_id = ? ";
		String sql2 = "delete from t_menu_role where role_id = ? ";
		try {
			boolean b1 =  jt.update(sql1, roleId) ;
			boolean b2 = jt.update(sql2, roleId);
			return b1 && b2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean roleNameModify(Integer roleId, String roleName) {
		String sql = "update t_role set role_name = ?  where role_id = ? ";
		try {
			return jt.update(sql, roleName, roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Role queryRoleByRoleId(Integer roleId) {
		String sql = "select * from t_role where role_id = ? ";
		try {
			List<Role> roleList = jt.query(sql, new RoleRowMapper(), roleId);
			return roleList.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Integer> queryAllAccessMenuIdByRoleId(Integer roleId) {
		String sql = "select menu_id from t_menu_role where role_id = ? and status = 1";
		try {
			return  jt.query(sql, new AccessMenuIdRowMapper(), roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	public boolean modifyRoleMenu(Integer roleId, List<Integer> menuList) {
		//把选中的菜单，置为1， 未选中的置为-1
		
		String menus = menuList.toString();
		menus = menus.replace('[', '(');
		menus = menus.replace(']',')');
		
		
		String sql1 = "update t_menu_role set status = 1 where role_id = ? and menu_id in" + menus;
		String sql2 = "update t_menu_role set status = -1 where role_id = ? and menu_id not in  " + menus;
		
		try {
			return jt.update(sql1,roleId) && jt.update(sql2, roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

	public static void main(String[] args) {
		RoleDaoImp roleDaoImp = new RoleDaoImp();
//		System.out.println(roleDaoImp.roleAdd("狗蛋"));
		 System.out.println(roleDaoImp.queryAllAccessMenuIdByRoleId(1));
		// System.out.println(roleDaoImp.roleNameModify(5, "二狗"));
		// System.out.println(roleDaoImp.queryAllRole());
		// System.out.println(roleDaoImp.queryRoleByRoleId(2));

	}

	
	
	

	
}
