<%@page import="Schoolmanagement.dto.Students"%>
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
    Students s1 =(Students)session.getAttribute("s");

%>

 <form action="Studentoptions.html">
id:<input type="text" value="<%= s1.getSid()%>"><br><br>
name:<input type="text" value="<%= s1.getSname()%>"><br><br>
dob:<input type="text" value="<%= s1.getDob()%>"><br><br>
cno:<input type="text" value="<%= s1.getScno()%>"><br><br>
email:<input type="text" value="<%= s1.getSemail()%>"><br><br>
password:<input type="text" value="<%= s1.getSpwd()%>"><br><br>
<input type= "submit" value="back"> 
</body>
</html>