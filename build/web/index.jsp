<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Gestión de Empleados</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow">

<div class="card-header header-sistema text-center">
<h2>Sistema de Gestión de Recursos Humanos</h2>
</div>

<div class="card-body">

<p class="text-center">
Seleccione el módulo que desea gestionar
</p>

<div class="row text-center">

<!-- Departamento -->
<div class="col-md-4 mb-3">
<div class="card card-sistema">
<div class="card-body">
<h5 class="card-title">Departamentos</h5>
<p class="card-text">Gestión de departamentos de la institución</p>

<a href="DepartamentoServlet?accion=listar" class="btn btn-sistema">
Ir al módulo
</a>

</div>
</div>
</div>

<!-- Cargos -->
<div class="col-md-4 mb-3">
<div class="card card-sistema">
<div class="card-body">
<h5 class="card-title">Cargos</h5>
<p class="card-text">Administración de cargos institucionales</p>

<a href="CargoServlet?accion=listar" class="btn btn-sistema">
Ir al módulo
</a>

</div>
</div>
</div>

<!-- Tipo Contratación -->
<div class="col-md-4 mb-3">
<div class="card card-sistema">
<div class="card-body">
<h5 class="card-title">Tipo de Contratación</h5>
<p class="card-text">Gestión de tipos de contratación</p>

<a href="TipoContratacionServlet?accion=listar" class="btn btn-sistema">
Ir al módulo
</a>

</div>
</div>
</div>

<!-- Empleados -->
<div class="col-md-6 mb-3">
<div class="card card-sistema">
<div class="card-body">
<h5 class="card-title">Empleados</h5>
<p class="card-text">Administración de empleados</p>

<a href="EmpleadoServlet?accion=listar" class="btn btn-sistema">
Ir al módulo
</a>

</div>
</div>
</div>

<!-- Contrataciones -->
<div class="col-md-6 mb-3">
<div class="card card-sistema">
<div class="card-body">
<h5 class="card-title">Contrataciones</h5>
<p class="card-text">Gestión de contratos laborales</p>

<a href="ContratacionServlet?accion=listar" class="btn btn-sistema">
Ir al módulo
</a>

</div>
</div>
</div>

</div>

</div>

<div class="card-footer text-center text-muted">
 Universidad Don Bosco
</div>

</div>

</div>

</body>
</html>