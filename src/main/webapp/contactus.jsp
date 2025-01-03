<%@page import="com.resturent1.Service_logic"%>
<%@page import="com.resturent1.contactdata"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String name=request.getParameter("name");
String email=request.getParameter("email");
String subject=request.getParameter("subject");
String message=request.getParameter("message");

contactdata d1=new contactdata();
d1.setName(name);
d1.setEmail(email);
d1.setSubject(subject);
d1.setMessage(message);

Service_logic s=new Service_logic();
int i=s.logic_contact(d1);

out.println("<h1>contact details updated</h1>"+i);




%>


</body>
</html>