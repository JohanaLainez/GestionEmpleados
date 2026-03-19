<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow-sm" style="max-width: 600px; margin: auto;">
            <div class="card-header bg-warning">
                <h3 class="mb-0">Editar Empleado</h3>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/EmpleadoServlet?accion=actualizar" method="POST">
                    
                    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">
                    
                    <div class="mb-3">
                        <label class="form-label">Número de DUI:</label>
                        <input type="text" name="numeroDui" class="form-control" required maxlength="9" value="${empleado.numeroDui}">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Nombre Completo:</label>
                        <input type="text" name="nombrePersona" class="form-control" required value="${empleado.nombrePersona}">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Usuario (Alias):</label>
                        <input type="text" name="usuario" class="form-control" required value="${empleado.usuario}">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Número de Teléfono:</label>
                        <input type="text" name="numeroTelefono" class="form-control" required maxlength="9" value="${empleado.numeroTelefono}">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Correo Institucional:</label>
                        <input type="email" name="correoInstitucional" class="form-control" required value="${empleado.correoInstitucional}">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Fecha de Nacimiento:</label>
                        <input type="date" name="fechaNacimiento" class="form-control" required value="${empleado.fechaNacimiento}">
                    </div>
                    
                    <div class="d-grid gap-2 mt-4">
                        <button type="submit" class="btn btn-warning">Actualizar Datos</button>
                        <a href="${pageContext.request.contextPath}/EmpleadoServlet?accion=listar" class="btn btn-outline-secondary">Cancelar</a>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
</body>
</html>