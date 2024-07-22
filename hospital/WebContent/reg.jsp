<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	function checkReg(){
		var flag=true;
		var name=document.getElementById("name").value;
		var pwd=document.getElementById("pwd").value;
//		var rePwd=document.getElementById("rePwd").value;
		if(""==name){
			alert("用户名不能为空！");
			flag=false;
			return false;
		}else if(""==pwd){
			alert("密码不能为空！");
			flag=false;
			return false;
		} /*   else if(""==rePwd){
			alert("请再次输入密码以确认！");
			flag=false;
			return false;
		}*/if(flag==true){
			return true;
		}
	}
</script>
<title>注册页面</title>
</head>
<body>
	<center>欢迎注册</center><br/>
	<center>
		<form action="reg.do" method="post">
			用户名：<input type="text" name="acount" id="name" /><br /> 
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="pwd" /><br />
			姓名(或昵称)：<input type="text" name="name"/><br/>
			属性（用户/医生）：<input type="text" name="type" id="rePwd"/><br/><br/>
			<input type="submit" value="提交" onclick="return checkReg();"/>
			<input type="button" value="返回" onclick="location='login.jsp'"/>
		</form>
	</center>
</body>
</html>