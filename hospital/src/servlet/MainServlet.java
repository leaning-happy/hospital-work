package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import dao.DoctorDao;
import dao.PatientDao;
import dao.ReFormDao;
import dao.UserDao;
import javamail.Sendmessage;
import poiexcel.ExcelUtils;
import users.ReForm;
//import jdbc.JDBCKit;
//import users.Doctor;
//import users.ReForm;
import users.User;

public class MainServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path=req.getServletPath();
		if(path.equals("/toLogin.do")){
			//�򿪵�¼ҳ
			toLogin(req,res);
		}else if(path.equals("/toReg.do")){
			//��ע��ҳ
			toReg(req,res);
		}else if(path.equals("/login.do")){
			//��¼��֤
			login(req,res);
		}else if(path.equals("/reg.do")){
			//ע����֤
			try {
				reg(req,res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("/guahao.do")) {
			try {
				guahao(req,res);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else if(path.equals("/cankan.do")) {
			try {
				cankan(req,res);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else if(path.equals("/guanli.do")) {
			try {
				guanli(req,res);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else if(path.equals("/dayin.do")){
			//��ע��ҳ
			try {
				daYin(req,res);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}else{
			throw new RuntimeException("404:ҳ�治���ڣ�����");
		}
	}	
	private void daYin(HttpServletRequest req, HttpServletResponse res) throws SQLException, Exception {
		DoctorDao doctor=new DoctorDao();
	
		String title[] = {

		        "���", "ҽ������", "��������","��Ԫ��","������"};

		String title_[] = {

		        "", "", "",","};
		ExcelUtils.createExcel("E:/ry.xls", "��Ա", title,title_,doctor.Dsql((String) req.getSession().getAttribute("name")));
		PrintWriter out=res.getWriter();
		out.print("<script language='javascript'> alert('successed');window.location.href='guanli.jsp'</script>");
	}
	private void cankan(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
		// TODO �Զ����ɵķ������
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		PatientDao patient=new PatientDao();
		ReFormDao reform=new ReFormDao();
		req.getSession().setAttribute("patient_list",patient.Psql((String) req.getSession().getAttribute("name")));
		req.getSession().setAttribute("re_list",reform.Rsql());//��list�������ݷ��뵽request�й���
		req.getRequestDispatcher("guahao.jsp").forward(req, res);
	}
	/*
	 * �򿪵�¼ҳ
	 */
	private void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		String url="login.jsp";
		req.getRequestDispatcher(url).forward(req, res);
	}

	/*
	 * ��ע��ҳ
	 */
	private void toReg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url="reg.jsp";
		req.getRequestDispatcher(url).forward(req, res);
	}
	
	/*
	 * ��¼��֤
	 */
	private void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
//		PrintWriter out=res.getWriter();
		String acount=new String(req.getParameter("acount"));
		String pwd=new String(req.getParameter("password"));
//		String type=new String(req.getParameter("type"));
//		System.out.println(type);
		User user=new User();
		user.setAcount(acount);
		user.setPassword(pwd);
		UserDao dao=new UserDao();
		boolean isLogin;
		try {
			isLogin=dao.login(user);
			if(isLogin){
				String name=" ";
				String type=dao.itstype(acount);
				if(type.equals("ҽ��")) {
					name=dao.readname(acount);
					res.sendRedirect("welcome.jsp");}
				else {
					name=dao.readpname(acount);
					res.sendRedirect("pwelcome.jsp");}
				req.getSession().setAttribute("name", name);
			}else{
				res.sendRedirect("back.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ע����֤
	 */
	private void reg(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException {
//		String path=req.getContextPath();
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();		
		String username=req.getParameter("acount"); 
		String password=req.getParameter("password");
		String type=req.getParameter("type");
		String name=req.getParameter("name");
		System.out.println("acount:"+username+",password:"+password+name);
		User user = new User();
		user.setAcount(username);
		user.setPassword(password);
		user.setType(type);
		UserDao userDao=new UserDao();
		String c=" ";
		if(userDao.userIsExist(username)){	
			boolean flag=userDao.reg(user);
			System.out.println(2);
			if(flag) {
				if(type.equals("ҽ��")) c="doctor";
				else c="patient";
				userDao.change(c, name,username);
				System.out.println("ע��ɹ���");
				req.getRequestDispatcher("regOK.jsp");}
			}
		else{
			System.out.println("ע��ʧ��(�û����Ѵ���)��");
			res.sendRedirect("regback.jsp");
		}
			out.flush();
			out.close();			
		}
	private void guahao(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		String dname=req.getParameter("id");
		String deptname=req.getParameter("deptid");
		System.out.println(dname);
		String pname=(String) req.getSession().getAttribute("name");
		ReFormDao refrom=new ReFormDao();
		Date today = new Date();
		@SuppressWarnings("deprecation")
		int h = today.getHours();
		int money=0;
		if((h>=14&&h<=18)||(h>=8&&h<=12)) money=10;
		else if(h>18&&h<22) money=15;
		else money=20;
		if(refrom.update(dname,pname,deptname,money))
		{
			Sendmessage.sendeMail(pname, h);
			res.sendRedirect("guahaoOK.jsp");
		};
	}
	private void guanli(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		DoctorDao doctor=new DoctorDao();
		req.getSession().setAttribute("key_list",doctor.Dsql((String) req.getSession().getAttribute("name")));//��list�������ݷ��뵽request�й���
		req.getRequestDispatcher("guanli.jsp").forward(req, res);

	}
}
