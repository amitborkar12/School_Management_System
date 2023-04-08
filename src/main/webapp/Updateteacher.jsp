<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="Schoolmanagement.dto.Teachers"%>
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
     Teachers t1 =(Teachers)session.getAttribute("t");
     
     
%>

<form action="UpdateTeacher.html">
id:<input type="number" value="<%= t1.getTid()%>"><br><br>
name:<input type="text" value="<%= t1.getTname()%>"><br><br>
subject:<input type="text" value="<%= t1.getSubject()%>"><br><br>
age:<input type="" value="<%= t1.getAge()%>"><br><br>
email:<input type="text" value="<%= t1.getTemail()%>"><br><br>
password:<input type="text" value="<%= t1.getTpwd()%>"><br><br>
<input type= "submit" value="update"> 
</form>

</body>
</html>