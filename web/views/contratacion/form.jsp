<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nueva Contratación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Registro de Contratación</h2>
    <div class="card p-4 shadow-sm">
        <form action="ContratacionServlet" method="POST">
            <input type="hidden" name="accion" value="insertar">

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label class="form-label">ID Empleado:</label>
                    <input type="number" name="idEmpleado" class="form-control" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label class="form-label">ID Departamento:</label>
                    <input type="number" name="idDepartamento" class="form-control" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label class="form-label">ID Cargo:</label>
                    <input type="number" name="idCargo" class="form-control" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label class="form-label">ID Tipo Contratación:</label>
                    <input type="number" name="idTipoContratacion" class="form-control" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label class="form-label">Fecha de Contratación:</label>
                    <input type="date" name="fechaContratacion" class="form-control" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label class="form-label">Salario:</label>
                    <input type="number" step="0.01" name="salario" class="form-control" required>
                </div>
            </div>

            <div class="mb-3 form-check">
                <input type="checkbox" name="estado" class="form-check-input" id="estado" checked>
                <label class="form-check-label" for="estado">Contratación Activa</label>
            </div>

            <div class="mt-4">
                <button type="submit" class="btn btn-sistema">Guardar Contratación</button>
                <a href="ContratacionServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>