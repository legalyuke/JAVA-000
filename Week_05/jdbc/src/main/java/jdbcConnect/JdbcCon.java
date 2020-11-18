package jdbc.src.main.java.jdbcConnect;

import java.sql.*;

/**
 * @author liyuke
 * @date 2020-11-18 21:44
 */
public class JdbcCon {


    void test() {
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "root";
    String sql = "";
     try {
         //获取连接
        Connection con = DriverManager.getConnection(url, username, password);
        //获取java.sql.Statement实例
        Statement stmt = con.createStatement() ;
        //查询
        ResultSet rs = stmt.executeQuery("SELECT * FROM ...") ;
        //更新
         int rows = stmt.executeUpdate("INSERT INTO ...") ;
         //执行其它语句
         boolean flag = stmt.execute(sql) ;

         //释放资源
         rs.close();
         stmt.close();
         con.close();

         }catch(SQLException e){
        System.out.println("数据库连接失败！");
        e.printStackTrace();
     }
}

}
