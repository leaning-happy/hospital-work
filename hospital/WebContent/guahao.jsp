<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.util.*" language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>病人挂号页面</title>
</head>
<body>
<%
			Date today = new Date();
			int h = today.getHours();
			int money=0;
			if((h>=14&&h<=18)||(h>=8&&h<=12)) money=10;
			else if(h>18&&h<22) money=15;
			else money=20;
			%>
<font color="blue">${sessionScope.name }用户</font><br/>
<font color="red">已挂号信息：</font><br/>
<table>
			<tr>
						<th>医生姓名</th>
						<th>科室&nbsp;</th>
						<th>金额</th>
						</tr>				
	        <c:forEach items="${patient_list}" var="pat" varStatus="idx">
	        <tr> 
		                <td>${pat.dname}</td>
		                <td>${pat.deptname}&nbsp;</td> 
		                <td>${pat.money}</td>
		                <td>
		                <form action="queren.jsp" method="post">
		                <input type="hidden" value="${pat.money}" name="money"/>
		                <input type="submit" value="立即支付" />
		                </form></td>	                
			</tr>
            </c:forEach>
</table>
<font color="red">请选择您要挂号的科室</font>
<table>
<tr><th>科室名&nbsp;&nbsp;</th><th>医生名&nbsp;&nbsp;</th><th>挂号费用</th></tr>
<c:forEach items="${re_list}" var="re" varStatus="idx">
<tr>
    <td>${re.deptname}</td>
    <td>${re.name}</td>
    <td><%out.print(money); %></td>
    <td>
    <form action="guahao.do" method="post">
    <input type="hidden" value="${re.deptname}" name="deptid" />
    <input type="text" value="${re.name}" style="display:none" name="id"/>
    <input type="submit" value="选择"  />
    </form></td>   
    </tr> 
</c:forEach>
</table>
</body>
</html>