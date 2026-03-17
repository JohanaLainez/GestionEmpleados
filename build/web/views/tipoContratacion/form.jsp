<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Tipo Contratación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">${tipoContratacion != null ? "Editar" : "Nuevo"} Tipo de Contratación</h2>
    <div class="card p-4 shadow-sm">
        <form action="TipoContratacionServlet" method="POST">
            <input type="hidden" name="accion" value="${tipoContratacion != null ? 'actualizar' : 'insertar'}">
            <input type="hidden" name="idTipoContratacion" value="${tipoContratacion.idTipoContratacion}">
            <div class="mb-3">
                <label class="form-label">Nombre del Tipo:</label>
                <input type="text" name="tipoContratacion" class="form-control" 
                       value="${tipoContratacion.tipoContratacion}" required>
            </div>
            <div class="mt-4">
                <button type="submit" class="btn btn-sistema">Guardar Registro</button>
                <a href="TipoContratacionServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>