package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCKit;
import users.ReForm;

public class DoctorDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql="";
	
	public List<ReForm> Dsql(String name) throws SQLException  {
		List<ReForm> reforms=new ArrayList<ReForm>();
		conn = JDBCKit.getConnection();
		sql="select * from reform where dname=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,name);
		rs=ps.executeQuery();
		try {
		while(rs.next()){
			ReForm reform=new ReForm();
			reform.setDname(rs.getString("dname"));
			reform.setPname(rs.getString("pname"));
			reform.setMoney(rs.getInt("money"));
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
}


