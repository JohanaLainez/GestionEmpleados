<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Contrataciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Gestión de Contrataciones</h2>

    <a href="ContratacionServlet?accion=nuevo" class="btn btn-sistema mb-3">
        Nueva Contratación
    </a>

    <table class="table table-bordered table-striped table-sistema">
        <thead>
            <tr>
                <th>ID</th>
                <th>Empleado</th>
                <th>Departamento</th>
                <th>Cargo</th>
                <th>Tipo</th>
                <th>Fecha</th>
                <th>Salario</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${lista}">
                <tr>
                    <td>${c.idContratacion}</td>
                    <td>${c.idEmpleado}</td> <%-- Luego cambiaremos esto por el nombre --%>
                    <td>${c.idDepartamento}</td>
                    <td>${c.idCargo}</td>
                    <td>${c.idTipoContratacion}</td>
                    <td>${c.fechaContracion}</td>
                    <td>$${c.salario}</td>
                    <td>
                        <span class="badge ${c.estado ? 'bg-success' : 'bg-danger'}">
                            ${c.estado ? 'Activo' : 'Inactivo'}
                        </span>
                    </td>
                    <td>
                        <a href="ContratacionServlet?accion=eliminar&id=${c.idContratacion}" 
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('¿Desea eliminar esta contratación?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-volver">Volver al inicio</a>
</div>
</body>
</html>