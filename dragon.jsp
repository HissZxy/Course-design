<%@ page language="java" contentType="text/html; charset=utf-8
"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dragon.jsp</title>
</head>
<body>
<%!
String message = "";
ServletContext application;
synchronized void sendMessage(String s){
	application = getServletContext();
	message = message+s+"->";
	application.setAttribute("message",message);
}
%>
<%
request.setCharacterEncoding("UTF-8");
String content = request.getParameter("msg");
sendMessage(content);
out.print("您的四字成语"+content+"已经提交,三秒后回到此页面继续接龙:");
response.setHeader("refresh","3;url = ldiom.jsp");
%>

</body>
</html>