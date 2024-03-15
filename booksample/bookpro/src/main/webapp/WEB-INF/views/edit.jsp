<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter ID to Edit</title>
</head>
<body>
<h1>Enter Book ID to Edit</h1>
<form action="${pageContext.request.contextPath}/editbook" method="post">
<label for= "bookid">Book ID:</label>
      <input type="number" id="bookid" name="bookid" required><br><br>
        <label for= "bookname">Book Name:</label> 
        <input type="text" id="bookname" name="bookname" required><br><br>
       <label for= "bookauthor"> Book Author:</label> 
       <input type="text"id="bookauthor" name="bookauthor" required><br><br>
        <label for= "bookprint">Book Print Location:</label>
         <input type="text" id="bookprint" name="bookprint" required><br><br>
         
        <input type="submit" value="Edit Book>>">
    </form>
    <br>
<br>
<p align="center">
<input type="button" value="Go to HomePage" onclick="window.location='${pageContext.request.contextPath}/'" />
</p>
</body>
</html>