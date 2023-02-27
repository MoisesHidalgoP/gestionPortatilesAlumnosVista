<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="/vistas/cabecera.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body>

<form action="portatilDelAlumno" method="POST">
  <label for="codAlumno">Código del Alumno:</label>
  <input type="number" id="codAlumno" name="codAlumno">
  <br>
  <input type=submit  value="Buscar">
</form>





</body>
    

</body>
</html>