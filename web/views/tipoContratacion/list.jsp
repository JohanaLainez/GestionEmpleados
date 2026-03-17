<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tipos de Contratación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Gestión de Tipos de Contratación</h2>
    <a href="TipoContratacionServlet?accion=nuevo" class="btn btn-sistema mb-3">
        Nuevo Tipo de Contratación
    </a>
    <table class="table table-bordered table-striped table-sistema">
        <thead>
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tc" items="${lista}">
                <tr>
                    <td>${tc.idTipoContratacion}</td>
                    <td>${tc.tipoContratacion}</td>
                    <td>
                        <a href="TipoContratacionServlet?accion=editar&id=${tc.idTipoContratacion}" class="btn btn-warning btn-sm">Editar</a>
                        <a href="TipoContratacionServlet?accion=eliminar&id=${tc.idTipoContratacion}" class="btn btn-danger btn-sm"
                           onclick="return confirm('¿Desea eliminar este registro?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-volver">Volver al inicio</a>
</div>
</body>
</html>