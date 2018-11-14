package transaction;

import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImp implements Transaction {
    @Override
    public void begin() {
        Connection con;
        try {
            con = JDBCUtil.getConnection();
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void commit() {
        Connection con;
        try {
            con = JDBCUtil.getConnection();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
    }

    @Override
    public void rollback() {
        Connection con;
        con = JDBCUtil.getConnection();
        if (con != null) {
            try {
//                con.close();
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtil.close();
            }
        }
    }
}
