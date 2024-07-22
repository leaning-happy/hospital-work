<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.util.*" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>登录成功</title>
</head>
<body>
	<center><font color="red">${sessionScope.name }医生,欢迎你！登陆成功！</font><br/>
		<%
			Date today = new Date();
			int d = today.getDay();
			int h = today.getHours();
			String s = "";
			if (h > 0 && h < 12)
				s = "上午好";
			else if (h >= 12)
				s = "下午好";
			String day[] = { "日", "一", "二", "三", "四", "五", "六" };
			out.println(s + "，今天是星期" + day[d]);
		%>
		<form action="guanli.do" >	
		<input type="submit" value="挂号管理" />
		</form>
	</center>
</body>
</html>