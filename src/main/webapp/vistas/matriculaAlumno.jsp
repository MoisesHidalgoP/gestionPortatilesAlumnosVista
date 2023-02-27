<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/vistas/cabecera.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>Nuevo Alumno</h1>
        
        <form action="guardarAlumno" method="POST">
  <label for="md_uuid">Md_uuid:</label>
  <input type="text" id="md_uuid" name="md_uuid">
  <br>
  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre">
  <br>
  <label for="dni">Telefono:</label>
  <input type="text" id="telefono" name="telefono">
  <br>
  <label for="marca">idPortatil:</label>
  <input type="text" id="idPortatil" name="idPortatil">
  <br/>
  <label for="marca">Marca:</label>
  <input type="text" id="marca" name="marca">
  <br>
  <label for="modelo">Modelo:</label>
  <input type="text" id="modelo" name="modelo">
  <br>
  <input type="submit" value="Insertar">
</form>
<input type="button" onclick="history.back()" name="Volver" value="Volver">

<h2>Lista de Portatiles</h2>

<c:forEach items="${miModelo.resultados}" var="resultados"> 
	<c:out value="${resultados}"/>
	<br/>
</c:forEach>


     



</body>
</html>