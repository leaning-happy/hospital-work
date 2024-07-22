package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCKit;
import users.User;

public class UserDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
//�û���¼
	public boolean login(User user) throws SQLException {	
		boolean returnValue = false;
		conn = JDBCKit.getConnection();
		sql="select * from user where acount=? and password=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,user.getAcount());
		ps.setString(2,user.getPassword());
		rs=ps.executeQuery();
		if(rs.next()){
			returnValue=true;
			rs.close();
			ps.close();
		}else{
			returnValue=false;
			rs.close();
			ps.close();
		}
		conn.close();
		return returnValue;
	}
//�ж��û�����
	public String itstype(String acount) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="select type from user where acount=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,acount);
		rs=ps.executeQuery();
		String type=" ";
		if(rs.next()) {
			type=rs.getString("type");
			rs.close();
			ps.close();	
		}
		return type;
	}
//��ȡҽ������
	public String readname(String acount) throws SQLException  {
		conn = JDBCKit.getConnection();
		sql="select name from doctor where acount=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,acount);
		rs=ps.executeQuery();
		String a=" ";
		if(rs.next()) {
			a=rs.getString("name");
			rs.close();
			ps.close();
			}
		return a;
	}
//��ȡ��������
	public String readpname(String acount) throws SQLException  {
		conn = JDBCKit.getConnection();
		sql="select name from patient where acount=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,acount);
		rs=ps.executeQuery();
		String b=" ";
		if(rs.next()) {
			b=rs.getString("name");
			rs.close();
			ps.close();
			}
		return b;
	}
//�����йر�
	public void change(String type,String name,String acount) throws SQLException {
		conn = JDBCKit.getConnection();
		sql="insert into ?(name,acount) values(?,?) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1,type);
		ps.setString(2, name);
		ps.setString(3, acount);
		ps.executeUpdate();
	}
	/*
	 * �û�ע��
	 */
	public boolean reg(User user) throws SQLException{
		boolean flag=false;
		conn=JDBCKit.getConnection();
		sql="insert into user(acount, password,type) values (?, ?,?)";		
		int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������
		try {
			ps = conn.prepareStatement(sql);
			if(user == null) {
				return false;
			}
			ps.setString(1, user.getAcount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getType());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag = result > 0 ? true : false;
		return flag;			
	}
		
	/*
     * �ж��û��������ݿ����Ƿ����
     */
    public boolean userIsExist(String username) throws SQLException{
        // ��ȡ���ݿ�����Connection����
        conn = JDBCKit.getConnection();
        // ����ָ���û�����ѯ�û���Ϣ
        sql = "select * from user where acount = ?";
        try {
            // ��ȡPreparedStatement����
            ps = conn.prepareStatement(sql);
            // ���û��������Ը�ֵ
            ps.setString(1, username);
            // ִ�в�ѯ��ȡ�����
            rs = ps.executeQuery();
            // �жϽ�����Ƿ���Ч
            if(!rs.next()){
               System.out.println(1);
                // �����Ч��֤�����û�������
                return true;
            }
            System.out.println(2);
            // �ͷŴ� ResultSet ��������ݿ�� JDBC ��Դ
            rs.close();
            // �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // �ر����ݿ�����
            conn.close();
        }
        return false;
    }
}



