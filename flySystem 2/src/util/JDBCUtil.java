package util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {


    //获得驱动源
    private static DataSource dataSource = null;

    //线程控制池（放Connection）
    private static ThreadLocal<Connection> threadLocal;


    //加载驱动
    static {
        threadLocal = new ThreadLocal<>();
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtil.class.getClassLoader()
                    .getResourceAsStream("datasource.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(pro);
            System.out.println("驱动加载成功");
        } catch (IOException e) {
            System.out.println("读取配置文件出错");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("JDBC驱动出错");
            e.printStackTrace();
        }
    }


//获得连接

    public static Connection getConnection() {
        Connection con = threadLocal.get();
        if (con == null) {
            try {
                con = dataSource.getConnection();
                threadLocal.set(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }


    // 关闭连接
    public static void close() {
        Connection con = threadLocal.get();
        if (con != null) {
            try {
                con.close();
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("驱动加载完成");
    }
}
