<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Found</title>
</head>
<body>
<h1>Search result</h1>
 <table border="1">
        <thead>
            <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Book Author</th>
                <th>Book Print Location</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>${bookid}</td>
                    <td>${bookname}</td>
                    <td>${bookauthor}</td>
                    <td>${bookprint}</td>
                </tr>
        </tbody>
    </table>
    <br>
<br>
<p align="center">
<input type="button" value="Go to HomePage" onclick="window.location='${pageContext.request.contextPath}/'" />
</p>
</body>
</html>