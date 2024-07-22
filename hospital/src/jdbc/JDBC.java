package jdbc;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws Exception{

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. ��������
            Class.forName("com.mysql.jdbc.Driver");
            // 2. ��������
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Hospital?characterEncoding=utf-8", "root", "");
            System.out.println("���ӳɹ�");
            // 3. ��ȡStatement
            stmt = conn.createStatement();
/**            // 4. �������ݿ�
            // 4.1 ����ڲ�����������
            stmt.executeUpdate("insert into OutpatientDepts( id,name, address, description) values (101,'��ǻ��', '��ƴ�¥102��', '��ǻ����');");
            stmt.executeUpdate("insert into OutpatientDepts(id, name, address, description) values (102,'�ۿ�', '�ڿƴ�¥203��', '�۲�����');");
            // 4.3 ��ѯbookmark��������
            rs = stmt.executeQuery("select * from OutpatientDepts;");
            // 4.5 ������ѯ��������
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
