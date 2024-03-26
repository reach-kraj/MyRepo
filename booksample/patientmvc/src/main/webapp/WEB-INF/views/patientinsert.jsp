<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Patient</title>
</head>
<body>
    <h2>Insert Patient</h2>
    <form action="${pageContext.request.contextPath}/insert" method="post">
        <label for="patientId">Patient ID:</label><br>
        <input type="text" id="patientId" name="patientId" required><br><br>

        <label for="patientName">Name:</label><br>
        <input type="text" id="patientName" name="patientName" required><br><br>

        <label for="patientAge">Age:</label><br>
        <input type="text" id="patientAge" name="patientAge" required><br><br>

        <label for="patientLocation">Location:</label><br>
        <input type="text" id="patientLocation" name="patientLocation" required><br><br>

        <label for="patientGender">Gender:</label><br>
        <select id="patientGender" name="patientGender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br><br>

        <input type="submit" value="Add Patient">
    </form>
</body>
</html>
