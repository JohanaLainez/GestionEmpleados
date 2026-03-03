<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Departamentos</title>
</head>
<body>
    <h2>Departamentos</h2>

    <a href="DepartamentoServlet?accion=nuevo">+ Nuevo</a>
    <br><br>

    <table border="1" cellpadding="6">
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
                        <a href="DepartamentoServlet?accion=editar&id=${d.idDepartamento}">Editar</a> |
                        <a href="DepartamentoServlet?accion=eliminar&id=${d.idDepartamento}"
                           onclick="return confirm('¿Eliminar este departamento?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="index.jsp">Volver</a>
</body>
</html>