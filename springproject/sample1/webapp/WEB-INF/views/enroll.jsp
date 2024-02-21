
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
    <c:forEach var="enroll" items="${enroll}">
    <a href="/WebApplication/HelloWorldServlet/courseenroll?courseid=_<c:out value='${enroll.courseid}'/>"><c:out value = '${enroll.courseid }'/></a>
    <c:out value = '${enroll.userid }'/>
    <c:out value = '${enroll.enrollmentid}'/>
    <c:out value = '${enroll.enrollmentdate }'/>
    <c:out value = '${enroll.courseid }'/>
    <br>
</c:forEach>
</body>
</html>