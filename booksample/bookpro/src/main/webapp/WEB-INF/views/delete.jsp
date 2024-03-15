<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Book to delete for collection</title>
</head>
<body>
<h1>Enter "Book ID" to Delete Book from collection</h1>
<form action="${pageContext.request.contextPath}/deletebook" method="post">
<label for= "bookid">Book ID:</label>
<input type="number" id="bookid" name="bookid" required><br><br>
<input type="submit" value="Delete book >>">
</form>
<br>
<br>
<p align="center">
<input type="button" value="Go to HomePage" onclick="window.location='${pageContext.request.contextPath}/'" />
</p>
</body>
</html>