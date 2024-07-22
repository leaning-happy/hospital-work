<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>医生查看挂号页面</title>
<style>th, tr, td, table {	
border: 1px solid red;}
</style>
</head>
<body>
<input type="button" value="退出系统" onclick="location=window.close()"/>
<form action="dayin.do" method="post"> 
<input type="submit" value="导出为excel表格" /></form><br/>
	<table>
			<tr>
						<th>医生姓名</th>
						<th>病人姓名</th>
						<th>金额</th>
						<th>科室</th></tr>				
	        <c:forEach items="${key_list}" var="usr" varStatus="idx">
	        <tr> 
		                <td>${usr.dname}</td>
		                <td>${usr.pname}</td> 
		                <td>${usr.money}</td>
		                <td>${usr.deptname}</td>
			</tr>
            </c:forEach>
</table>
</body>
</html>
