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

<!--<table>
<tr>
<th><p align="center">
<input type="button" value="Add book" onclick="window.location='${pageContext.request.contextPath}/add'" />
</p></th>
<th><p align="center">
<input type="button" value="Search book" onclick="window.location='${pageContext.request.contextPath}/search'" />
</p></th>
<th><p align="center">
<input type="button" value="Show all book" onclick="window.location='${pageContext.request.contextPath}/list'" />
</p></th>
<th><p align="center">
<input type="button" value="Edit book" onclick="window.location='${pageContext.request.contextPath}/editbook'" />
</p></th>
<th><p align="center">
<input type="button" value="Delete book" onclick="window.location='${pageContext.request.contextPath}/deletebook'" />
</p></th>
</tr>
</table>-->

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
<input type="button" value="Edit book" onclick="window.location='${pageContext.request.contextPath}/edit'" />
</p>
<p align="center">
<input type="button" value="Delete book" onclick="window.location='${pageContext.request.contextPath}/delete'" />
</p>
</body>
</html>