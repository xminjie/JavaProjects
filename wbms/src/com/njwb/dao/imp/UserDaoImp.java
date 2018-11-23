package com.njwb.dao.imp;

import java.util.List;

import org.apache.log4j.Logger;

import com.njwb.dao.UserDao;
import com.njwb.entity.Menu;
import com.njwb.entity.User;
import com.njwb.rowmapper.imp.MenuRowMapper;
import com.njwb.rowmapper.imp.UserRowMapper;
import com.njwb.util.JDBCTemplate;

public class UserDaoImp implements UserDao {
	Logger log = Logger.getLogger(UserDaoImp.class);
	JDBCTemplate jt = new JDBCTemplate();

	public User queryByAccount(String account) {
		String sql = "select * ,1 = 1 from t_user where account = ? ";
		try {

			List list = jt.query(sql, new UserRowMapper(), account);
			if (list != null && list.size() == 1) {
				return (User) list.get(0);
			} else {
				log.info("查到好几个用户");
			}
		} catch (Exception e) {
			log.error("查询有毛病", e);
		}
		return null;
	}

	public User queryByAccountAndPasswd(String account, String passwd) {
		String sql = "select * ,1 = 1 from t_user where account = ? and passwd = ? and status != -1";
		try {

			List list = jt.query(sql, new UserRowMapper(), account, passwd);
			if (list != null && list.size() == 1) {
				return (User) list.get(0);
			} else {
				log.info("查到好几个用户");
			}
		} catch (Exception e) {
			log.error("查询有毛病", e);
		}
		return null;
	}

	// 查询父菜单
	public List<Menu> queryFaMenuByRoleId(Integer roleId) {

		String sql = " select menu_id,menu_name, menu_href_url, menu_parent_id from t_menu where "
				+ "  menu_parent_id = -1 and menu_id in (select menu_id from t_menu_role where role_id = ? and status = 1 ) "
				+ "  order by menu_id ;";
		try {
			return jt.query(sql, new MenuRowMapper(), roleId);
		} catch (Exception e) {
			log.error("查询一级菜单出错", e);
			e.printStackTrace();
		}
		return null;
	}

	// 查询子菜单
	public List<Menu> querySonMenuByFaMenuIdAndRoleId(Integer faMenuId,
			Integer roleId) {
		String sql = " select menu_id,menu_name, menu_href_url, menu_parent_id from t_menu where "
				+ "  menu_parent_id  = ? and menu_id in (select menu_id from t_menu_role where role_id = ? and status = 1 ) "
				+ "  order by menu_id  ";
		try {
			return jt.query(sql, new MenuRowMapper(), faMenuId, roleId);
		} catch (Exception e) {
			log.error("查二级菜单出错", e);
			e.printStackTrace();
		}
		return null;
	}

	public boolean addUserByAccountAndPasswd(String account, String passwd) {
		String sql = "insert into t_user (account,passwd, role_id, create_time) "
				+ "values (?,? , 0 ,now());";
		try {
			return jt.update(sql, account, passwd);
		} catch (Exception e) {
			log.error("把员工添加到用户表出错", e);
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUserByAccount(String account) {
		String sql = "delete from t_user where account =  ?  ";
		try {
			return jt.update(sql, account);
		} catch (Exception e) {
			log.error("删除账户出错", e);
			e.printStackTrace();
		}
		return false;
	}

	public boolean userAbleByAccount(String account) {
		String sql = "update t_user set status = status * -1 where account = ?";
		try {
			return jt.update(sql, account);
		} catch (Exception e) {
			log.error("启用禁用账户出错", e);
			e.printStackTrace();
		}
		return false;
	}

	public List<User> queryAllUser() {
		// query all users;

		String sql = "select * , (select role_name from t_role where t_user.role_id = t_role.role_id ) as role_name from t_user  where account != 'root' ";

		try {
			return jt.query(sql, new UserRowMapper());
		} catch (Exception e) {
			// query all users fialed;
			e.printStackTrace();
		}
		return null;
	}

	public boolean uerRoleModify(String account, Integer roleId) {
		String sql = "update t_user set role_id = ? where account = ? ";

		try {
			return jt.update(sql, roleId,account);
		} catch (Exception e) {
			// query all users fialed;
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		UserDaoImp userDaoImp = new UserDaoImp();
		// System.out.println(userDaoImp.queryByAccountAndPasswd("admin",
		// "admin"));
		// System.out.println(userDaoImp.queryFaMenuByRoleId(1));
		// System.out.println(userDaoImp.deleteUserByAccount("aaa"));
		// System.out.println(userDaoImp.addUserByAccountAndPasswd("aaa", "aaa")
		// );
		// System.out.println(userDaoImp.userAbleByAccount("aaa"));
		System.out.println(userDaoImp.queryAllUser());

	}

	public boolean modifyUserPasswd(String account, String password) {
		String sql = "update t_user set passwd = ? where account = ? ";

		try {
			return jt.update(sql, password,account);
		} catch (Exception e) {
			// query all users fialed;
			e.printStackTrace();
		}
		return false;
	}

}
