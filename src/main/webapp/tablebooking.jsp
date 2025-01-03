<%@page import="com.resturent1.Service_logic"%>
<%@page import="com.resturent1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>table booking</title>
</head>
<body>

<% 

String name=request.getParameter("name");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String dob=request.getParameter("date");
String time=request.getParameter("time");
String people=request.getParameter("people");
String message=request.getParameter("message");


Data d=new Data();
d.setName(name);
d.setEmail(email);
d.setPhone(phone);
d.setDob(dob);
d.setTime(time);
d.setPeople(people);
d.setMessage(message);

Service_logic s=new Service_logic();
int i=s.logic_booking(d);

out.println("<h1>your bookings was confirmed </h1>"+i);


%>

</body>
</html>