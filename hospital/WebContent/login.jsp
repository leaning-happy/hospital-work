<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function checkLogin(){
		var flag=true;
		var name=document.getElementById("name").value;
		var pwd=document.getElementById("pwd").value;
		if(""==name){
			alert("用户名不能为空！");
			flag=false;
			return false;
		}else if(""==pwd){
			alert("密码不能为空！");
			flag=false;
			return false;
		}if(flag==true){
			return true;
		}
	}
</script>
<title>登录页面</title>
</head>
<body>
	<center>欢迎登录</center><br/>
	<center>
		<form action="login.do" method="post">
			用户名：<input type="text" name="acount" id="name" /><br /> 
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="pwd" /><span style="color:red" id="pwdMsg"></span><br /> <br />
			<input type="submit" value="登录" onclick="return checkLogin();"/>
			<input type="button" value="注册" onclick="location='reg.jsp'"/> 
		</form>
	</center>
</body>
</html>