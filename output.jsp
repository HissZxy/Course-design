<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%@  page import ="com.longin" %>>
<!DOCTYPE html>
<html>
<head>
</head>
<body>


<%
	request.setCharacterEncoding("GBK") ;
%>
 <jsp:useBean id="reg" class="com.longin" scope="page"></jsp:useBean>
    <jsp:setProperty property="*" name="reg"/>
           姓名：<jsp:getProperty property="username" name="reg"/> <br/>
	性别：<jsp:getProperty property="sex" name="reg"/> <br/>
	民族：<jsp:getProperty property="nation" name="reg"/> <br/>
	年龄：<jsp:getProperty property="age" name="reg"/> <br/>
	爱好：<jsp:getProperty property="hobby" name="reg"/>
    个人介绍：<jsp:getProperty property="description" name="reg"/> <br/>

</body>
</html>
