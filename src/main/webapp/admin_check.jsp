<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> login check</title>
</head>
<body>

<%
String userName = request.getParameter("email");
String password = request.getParameter("password");

if(userName.equalsIgnoreCase("Admin")&& password.equalsIgnoreCase("Admin") ){
response.sendRedirect("adminhome.jsp");
}else{
response.sendRedirect("adminlogin.jsp?msg1=faild");
}


%>

</body>
</html>