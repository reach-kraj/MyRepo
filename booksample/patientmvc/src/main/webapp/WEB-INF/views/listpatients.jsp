<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Patients</title>
</head>
<body>
    <h1>List of Patients</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Patient ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Location</th>
                <th>Gender</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>${patient.patientId}</td>
                    <td>${patient.patientName}</td>
                    <td>${patient.patientAge}</td>
                    <td>${patient.patientLocation}</td>
                    <td>${patient.patientGender}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
