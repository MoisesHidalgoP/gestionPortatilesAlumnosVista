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
<h1>Nuevo Portatil</h1>
    <form:form method="POST" action="guardarPortatil" modelAttribute="portatil">
                 <table>
                
                <tr>
                    <td><form:label path="md_uuid">Md_uuid</form:label></td>
                    <td><form:input path="md_uuid"/></td>
                </tr>
                <tr>
                    <td><form:label path="marca">Marca</form:label></td>
                    <td><form:input path="marca"/></td>
                </tr>
                <tr>
                    <td><form:label path="modelo">Modelo</form:label></td>
                    <td><form:input path="modelo"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Insertar"/></td>
                </tr>
            </table>
            
        </form:form> 
        
        <input type="button" onclick="history.back()" name="Volver" value="Volver">

</body>
</html>