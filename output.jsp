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
           ������<jsp:getProperty property="username" name="reg"/> <br/>
	�Ա�<jsp:getProperty property="sex" name="reg"/> <br/>
	���壺<jsp:getProperty property="nation" name="reg"/> <br/>
	���䣺<jsp:getProperty property="age" name="reg"/> <br/>
	���ã�<jsp:getProperty property="hobby" name="reg"/>
    ���˽��ܣ�<jsp:getProperty property="description" name="reg"/> <br/>

</body>
</html>
