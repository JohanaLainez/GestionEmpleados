<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Departamento</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow">

<div class="card-header header-sistema text-white">
<c:choose>
<c:when test="${departamento != null}">
Editar Departamento
</c:when>
<c:otherwise>
Nuevo Departamento
</c:otherwise>
</c:choose>
</div>

<div class="card-body">

<form action="DepartamentoServlet" method="post">

<c:choose>
<c:when test="${departamento != null}">
<input type="hidden" name="accion" value="actualizar">
<input type="hidden" name="idDepartamento" value="${departamento.idDepartamento}">
</c:when>

<c:otherwise>
<input type="hidden" name="accion" value="insertar">
</c:otherwise>
</c:choose>

<div class="mb-3">

<label class="form-label">Nombre</label>

<input
type="text"
name="nombreDepartamento"
class="form-control"
value="${departamento.nombreDepartamento}"
required>

</div>

<div class="mb-3">

<label class="form-label">Descripción</label>

<textarea
name="descripcionDepartamento"
class="form-control"
rows="3">${departamento.descripcionDepartamento}</textarea>

</div>

<button type="submit" class="btn btn-sistema">
Guardar
</button>

<a href="DepartamentoServlet?accion=listar" class="btn btn-sistema">
Cancelar
</a>

</form>

</div>

</div>

</div>

</body>
</html>