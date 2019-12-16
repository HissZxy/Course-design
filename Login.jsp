
<%@page import="com.sun.corba.se.spi.orbutil.fsm.Action"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int flag = 0;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				 if("user".equals(cookies[i].getValue())){
					request.getRequestDispatcher("/hello.jsp").forward(request, response);
				} 
			}
		}
		

 	%>
	<form action="/Logintest/LoginManage" method="post">
		用户名：<input type="text" name="username" /></br> 密码：<input type="password"
			name="passwd" /></br> 两周内免登录<input type="checkbox" name="freeLogin"
			value="fastway" /></br> <input type="submit" value="登录">
	</form>
</body>
</html>