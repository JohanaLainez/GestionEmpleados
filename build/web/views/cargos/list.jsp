<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cargos</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container mt-5">

    <h2 class="mb-4">Gestión de Cargos</h2>

    <a href="CargoServlet?accion=nuevo" class="btn btn-sistema mb-3">
        Nuevo Cargo
    </a>

    <table class="table table-bordered table-striped table-sistema">
        <thead>
            <tr>
                <th>ID</th>
                <th>Cargo</th>
                <th>Descripción</th>
                <th>Jefatura</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${lista}">
                <tr>
                    <td>${c.idCargo}</td>
                    <td>${c.cargo}</td>
                    <td>${c.descripcionCargo}</td>
                    <td>
                        <c:choose>
                            <c:when test="${c.jefatura}">Sí</c:when>
                            <c:otherwise>No</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="CargoServlet?accion=editar&id=${c.idCargo}" class="btn btn-warning btn-sm">
                            Editar
                        </a>
                        <a href="CargoServlet?accion=eliminar&id=${c.idCargo}" class="btn btn-danger btn-sm"
                           onclick="return confirm('¿Desea eliminar este cargo?')">
                            Eliminar
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="index.jsp" class="btn btn-volver">Volver al inicio</a>

</div>

</body>
</html>