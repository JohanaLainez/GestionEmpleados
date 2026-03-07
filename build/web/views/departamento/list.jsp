<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Departamentos</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container mt-5">

    <h2 class="mb-4">Gestión de Departamentos</h2>

    <a href="DepartamentoServlet?accion=nuevo" class="btn btn-sistema mb-3">
        Nuevo Departamento
    </a>

    <table class="table table-bordered table-striped table-sistema">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="d" items="${lista}">
                <tr>
                    <td>${d.idDepartamento}</td>
                    <td>${d.nombreDepartamento}</td>
                    <td>${d.descripcionDepartamento}</td>
                    <td>
                        <a href="DepartamentoServlet?accion=editar&id=${d.idDepartamento}" class="btn btn-warning btn-sm">Editar</a>
                        <a href="DepartamentoServlet?accion=eliminar&id=${d.idDepartamento}" class="btn btn-danger btn-sm"
                           onclick="return confirm('¿Desea eliminar este departamento?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="index.jsp" class="btn btn-volver">Volver al inicio</a>

</div>

</body>
</html>