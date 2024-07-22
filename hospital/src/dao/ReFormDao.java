package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCKit;
import users.Doctor;
import users.ReForm;

public class ReFormDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
	
	public List<Doctor> Rsql() throws SQLException  {
		List<Doctor> reforms=new ArrayList<Doctor>();
		conn = JDBCKit.getConnection();
		sql="select * from doctor";
		ps = conn.prepareStatement(sql);
		rs=ps.executeQuery();
		try {
		while(rs.next()){
			Doctor reform=new Doctor();
			reform.setName(rs.getString("name"));
//			reform.setPname(rs.getString("pname"));
			reform.setDeptname(rs.getString("deptname"));
			reforms.add(reform);
		}
		return reforms;
	} catch (Exception e)
	{
		// TODO: handle exception
		e.printStackTrace();
		JDBCKit.release(rs, null, conn);
		return null;
	}
}
   public boolean update(String dname,String pname,String deptname, Integer money) throws SQLException {
	   try{
	   conn = JDBCKit.getConnection();
	   sql="insert into reform(dname,pname,deptname,money) values(?,?,?,?)";
	   ps = conn.prepareStatement(sql);
	   ps.setString(1,dname);
	   ps.setString(2, pname);
	   ps.setString(3, deptname);
	   ps.setLong(4, money);
	   ps.executeUpdate();
	   return true;
	} catch (Exception e)
	{
		// TODO: handle exception
		e.printStackTrace();
		return false;
   }
}
}
