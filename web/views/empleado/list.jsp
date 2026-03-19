<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2 class="mb-4 text-primary">Lista de Empleados</h2>
        
        <a href="${pageContext.request.contextPath}/EmpleadoServlet?accion=nuevo" class="btn btn-primary mb-3">Agregar Nuevo Empleado</a>
        
        <div class="card shadow-sm">
            <div class="card-body">
                <table class="table table-hover table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>DUI</th>
                            <th>Nombre</th>
                            <th>Usuario</th>
                            <th>Teléfono</th>
                            <th>Correo</th>
                            <th>Fecha Nacimiento</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="emp" items="${empleados}">
                            <tr>
                                <td>${emp.idEmpleado}</td>
                                <td>${emp.numeroDui}</td>
                                <td>${emp.nombrePersona}</td>
                                <td>${emp.usuario}</td>
                                <td>${emp.numeroTelefono}</td>
                                <td>${emp.correoInstitucional}</td>
                                <td>${emp.fechaNacimiento}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/EmpleadoServlet?accion=editar&id=${emp.idEmpleado}" 
                                       class="btn btn-warning btn-sm">
                                       Editar
                                    </a>

                                    <a href="${pageContext.request.contextPath}/EmpleadoServlet?accion=eliminar&id=${emp.idEmpleado}" 
                                       class="btn btn-danger btn-sm" 
                                       onclick="return confirm('¿Estás seguro de que deseas eliminar este empleado?');">
                                       Eliminar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al Inicio</a>
    </div>
</body>
</html>