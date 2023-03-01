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

<form:form method="POST" 
          action="portatilDelAlumno" modelAttribute="alumnosGM">
             <table>
                
                
                <tr>
                    <td><form:label path="codAlumno">Codigo del Alumno</form:label></td>
                    <td><form:input path="codAlumno"/></td>
                </tr>
                
                
               
                <tr>
                    <td><input type="submit" value="Buscar"/></td>
                </tr>
            </table>
        </form:form>





</body>
    

</body>
</html>