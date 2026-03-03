<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Departamento</title>
</head>
<body>

<c:set var="d" value="${departamento}" />

<h2>
    <c:choose>
        <c:when test="${d != null}">Editar Departamento</c:when>
        <c:otherwise>Nuevo Departamento</c:otherwise>
    </c:choose>
</h2>

<form method="post" action="DepartamentoServlet">

    <c:choose>
        <c:when test="${d != null}">
            <input type="hidden" name="accion" value="actualizar">
            <input type="hidden" name="idDepartamento" value="${d.idDepartamento}">
        </c:when>
        <c:otherwise>
            <input type="hidden" name="accion" value="insertar">
        </c:otherwise>
    </c:choose>

    <label>Nombre:</label><br>
    <input type="text" name="nombreDepartamento" value="${d.nombreDepartamento}" required><br><br>

    <label>Descripción:</label><br>
    <textarea name="descripcionDepartamento" rows="4" cols="40">${d.descripcionDepartamento}</textarea><br><br>

    <button type="submit">Guardar</button>
    <a href="DepartamentoServlet?accion=listar">Cancelar</a>
</form>

</body>
</html>