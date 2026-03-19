<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow-sm" style="max-width: 600px; margin: auto;">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0">Registrar Empleado</h3>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/EmpleadoServlet?accion=guardar" method="POST">
                    
                    <div class="mb-3">
                        <label class="form-label">Número de DUI:</label>
                        <input type="text" name="numeroDui" class="form-control" required maxlength="9" placeholder="Ej: 123456789">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Nombre Completo:</label>
                        <input type="text" name="nombrePersona" class="form-control" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Usuario (Alias):</label>
                        <input type="text" name="usuario" class="form-control" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Número de Teléfono:</label>
                        <input type="text" name="numeroTelefono" class="form-control" required maxlength="9" placeholder="Ej: 77778888">
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Correo Institucional:</label>
                        <input type="email" name="correoInstitucional" class="form-control" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Fecha de Nacimiento:</label>
                        <input type="date" name="fechaNacimiento" class="form-control" required>
                    </div>
                    
                    <div class="d-grid gap-2 mt-4">
                        <button type="submit" class="btn btn-success">Guardar Empleado</button>
                        <a href="${pageContext.request.contextPath}/EmpleadoServlet?accion=listar" class="btn btn-outline-secondary">Cancelar y volver a la lista</a>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
</body>
</html>