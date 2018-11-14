package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemp {
    public void update(String sql, Object... params) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pre;
        try {
            pre = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
//                if (params[i] instanceof Integer) {
//                    pre.setInt(i + 1, (int)params[i]);
//                } else {
//                    pre.setObject(i + 1, params[i]);
//                }
                pre.setObject(i + 1, params[i]);
            }
            System.out.println(pre.toString());
            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List Query(String sql, RowMap row, Object... params) {
        Connection con = JDBCUtil.getConnection();
        ArrayList<Object> list = new ArrayList<>();
        PreparedStatement pre;
        ResultSet res;
        try {
            pre = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    pre.setInt(i + 1, (int)params[i]);
                } else {
                    pre.setObject(i + 1, params[i]);
                }
            }
            System.out.println(pre.toString());
            res = pre.executeQuery();
            if (res == null) return null;
            while (res.next()) {
                list.add(row.getRowmap(res));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
