
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course</title>
</head>
<body>
    <h1>Course</h1>
    <c:forEach var="course" items="${listcourse}">
    <a href="/WebApplication/HelloWorldServlet/courseenroll?courseid=_<c:out value='${course.courseid}'/>"><c:out value = '${course.courseid }'/></a>
    <c:out value = '${course.coursename }'/>
    <c:out value = '${course.coursecategory}'/>
    <c:out value = '${course.credits }'/>
   <br>
       
       
</c:forEach>
</body>
</html>










