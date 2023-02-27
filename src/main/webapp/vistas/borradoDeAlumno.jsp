<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script >
function pregunta(){
    if (confirm('¿Estas seguro que quieres dar de baja a este alumno?')){
       document.tuformulario.submit()
    }
}
</script>


</head>
<body>
  <form action="borrarAlumno" method="POST">
  <label for="codAlumno">Código del Alumno:</label>
  <input type="number" id="codAlumno" name="codAlumno">
  <br>
  <input type=submit onclick="pregunta()" value="Borrar">
  
</form>
    
</body>
</html>