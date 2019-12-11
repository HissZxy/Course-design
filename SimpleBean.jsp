<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javebean count</title>
</head>
<body>
<center>  
<fieldset class="width:400px">  
<legend>access sumary</legend>  
 <!-- one guest -->  
 <jsp:useBean id="personcount" class="com.CountBean" scope="session"/>  
 <!-- all guests -->  
 <jsp:useBean id="totalcount" class="com.CountBean" scope="application"/>  
   
 count for u:<jsp:getProperty name="personcount" property="count"/><br/>  
count for site:<jsp:getProperty name="totalcount" property="count"/><br/>  
 <input type="button" value="refresh" onClick="location.reload()"/> </fieldset>  
</center>
</body>
</html>