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
//用户登录
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
//判断用户类型
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
//读取医生姓名
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
//读取患者姓名
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
//更新有关表
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
	 * 用户注册
	 */
	public boolean reg(User user) throws SQLException{
		boolean flag=false;
		conn=JDBCKit.getConnection();
		sql="insert into user(acount, password,type) values (?, ?,?)";		
		int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数
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
     * 判断用户名在数据库中是否存在
     */
    public boolean userIsExist(String username) throws SQLException{
        // 获取数据库连接Connection对象
        conn = JDBCKit.getConnection();
        // 根据指定用户名查询用户信息
        sql = "select * from user where acount = ?";
        try {
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(sql);
            // 对用户对象属性赋值
            ps.setString(1, username);
            // 执行查询获取结果集
            rs = ps.executeQuery();
            // 判断结果集是否有效
            if(!rs.next()){
               System.out.println(1);
                // 如果无效则证明此用户名可用
                return true;
            }
            System.out.println(2);
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            conn.close();
        }
        return false;
    }
}



