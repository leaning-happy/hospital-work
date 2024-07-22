package jdbc;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws Exception{

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Hospital?characterEncoding=utf-8", "root", "");
            System.out.println("连接成功");
            // 3. 获取Statement
            stmt = conn.createStatement();
/**            // 4. 操作数据库
            // 4.1 向表内插入两条数据
            stmt.executeUpdate("insert into OutpatientDepts( id,name, address, description) values (101,'口腔科', '外科大楼102室', '口腔疾病');");
            stmt.executeUpdate("insert into OutpatientDepts(id, name, address, description) values (102,'眼科', '内科大楼203室', '眼部疾病');");
            // 4.3 查询bookmark表中数据
            rs = stmt.executeQuery("select * from OutpatientDepts;");
            // 4.5 遍历查询结果并输出
            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name")
                        + ", address: " + rs.getString(3) + ", description: " + rs.getString("description"));
            }**/
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                rs.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }
}
