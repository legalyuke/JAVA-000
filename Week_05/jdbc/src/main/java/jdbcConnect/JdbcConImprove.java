package jdbc.src.main.java.jdbcConnect;

import java.sql.*;

/**
 * @author liyuke
 * @date 2020-11-18 22:07
 */
public class JdbcConImprove {

    void test() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        String sql = "";
        try {
            //获取连接
            Connection con = DriverManager.getConnection(url, username, password);
            //获取java.sql.Statement实例
            Statement stmt = con.createStatement();
            //预处理语句可以改善批量查询
            PreparedStatement ps = con.prepareStatement(
                    "INSERT into employees values (?, ?, ?)");

            for (int n = 0; n < 100; n++) {

                ps.setString(name[n]);
                ps.setLong(id[n]);
                ps.setInt(salary[n]);
                ps.addBatch();
            }
            ps.executeBatch();

            //释放资源
            ps.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}
