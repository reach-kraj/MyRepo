<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IG Book Collection</title>
</head>

<body>
<h1 align="center">
Welcome To InfoGrass Book Collection
</h1>


<p align="center">
<input type="button" value="Add book" onclick="window.location='${pageContext.request.contextPath}/add'" />
</p>
<p align="center">
<input type="button" value="Search book" onclick="window.location='${pageContext.request.contextPath}/search'" />
</p>
<p align="center">
<input type="button" value="Show all book" onclick="window.location='${pageContext.request.contextPath}/list'" />
</p>
<p align="center">
<input type="button" value="Edit book" onclick="window.location='${pageContext.request.contextPath}/editlist'" />
</p>
<p align="center">
<input type="button" value="Delete book" onclick="window.location='${pageContext.request.contextPath}/deletelist'" />
</p>
</body>
</html>