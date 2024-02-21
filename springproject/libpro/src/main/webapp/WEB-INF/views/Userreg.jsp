<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert</title>
</head>
<body>
	<form action="Insert" method="post"> 
		<Table>
		<tr>
		<td>Username:</td>
		<td><input type="text" name="username"/> </td>
		</tr>
		
		<tr>
		<td>Password:</td> 
		<td><input type="text" name="password"/> </td>
		</tr>
		
		<tr>
		<td>Date of Birth:</td> 
		<td><input type="date" name="dob"/> </td>
		</tr>
				
		<td colspan="2" align="center"><input type="submit" value="Insert"/> </td>
		</Table>
	</form> 
</body>
</html>