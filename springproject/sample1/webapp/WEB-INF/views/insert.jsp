<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Course</title>
</head>
<body>
    <h1>Insert New Course</h1>
    <form action="${pageContext.request.contextPath}/insertCourse" method="post">
        Course ID: <input type="number" name="courseid"><br>
        Course Name: <input type="text" name="coursename"><br>
        Course Category: <input type="text" name="coursecategory"><br>
        Credits: <input type="number" name="credits"><br>
       
        <input type="submit" value="Add Course>>>">
    </form>
</body>
</html>