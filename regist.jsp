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
    <p>�û�����
    <input type="text" name="username" value=""></p>
   
    <p>���룺   <input type="password" name="password"value="" required placeholder="���볤�ȱ������3λ"></p>
    
    <p>�Ա�
        <input type="radio" name="sex" value="Ů">Ů
        <input type="radio" name="sex" value="��">��
        
   <p>����:
         <select name="nation" id="reg">
        <option value="����">����</option>
        <option value="ά�����">ά�����</option>
         <option value="����">����</option>
        </select>   
   <p> ����:<input type="text"   name="age"  value="">
       <p>���ã�
        <input type="checkbox" name="hobby" value="��Ӿ">��Ӿ
        <input type="checkbox" name="hobby" value="��ë��">��ë��
        <input type="checkbox" name="hobby" value="����">����
        <input type="checkbox" name="hobby" value="ƹ����">ƹ����
   <p>���˽���:       <textarea rows="5" cols="50" name="description"></textarea>
  <td colspan="2"><input type="submit" name="submit" value="ע��">   <input type="reset"></td>                                  
                    
</body>
</html>
