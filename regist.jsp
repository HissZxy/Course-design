<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("GBK") ;
%>
   <jsp:useBean id="reg" class="com.longin" scope="page"></jsp:useBean>
   <form action="output.jsp" method="post">
   <input type ="hidden" name="flag"> 
   <table>
    <p>用户名：
    <input type="text" name="username" value=""></p>
   
    <p>密码：   <input type="password" name="password"value="" required placeholder="密码长度必须大于3位"></p>
    
    <p>性别：
        <input type="radio" name="sex" value="女">女
        <input type="radio" name="sex" value="男">男
        
   <p>民族:
         <select name="nation" id="reg">
        <option value="汉族">汉族</option>
        <option value="维吾尔族">维吾尔族</option>
         <option value="回族">回族</option>
        </select>   
   <p> 年龄:<input type="text"   name="age"  value="">
       <p>爱好：
        <input type="checkbox" name="hobby" value="游泳">游泳
        <input type="checkbox" name="hobby" value="羽毛球">羽毛球
        <input type="checkbox" name="hobby" value="篮球">篮球
        <input type="checkbox" name="hobby" value="乒乓球">乒乓球
   <p>个人介绍:       <textarea rows="5" cols="50" name="description"></textarea>
  <td colspan="2"><input type="submit" name="submit" value="注册">   <input type="reset"></td>                                  
                    
</body>
</html>
