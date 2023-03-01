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
    <p>Id: ${portatil.idPortatil}</p>
    <p>Marca: ${portatil.marca}</p>
    <p>Modelo: ${portatil.modelo}</p>
 <button onclick="history.back()">Volver</button>

</body>
</html>