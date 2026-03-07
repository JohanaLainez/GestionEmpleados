<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Cargo</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header header-sistema text-white">
            <c:choose>
                <c:when test="${cargo != null}">
                    Editar Cargo
                </c:when>
                <c:otherwise>
                    Nuevo Cargo
                </c:otherwise>
            </c:choose>
        </div>

        <div class="card-body">

            <form action="CargoServlet" method="post">

                <c:choose>
                    <c:when test="${cargo != null}">
                        <input type="hidden" name="accion" value="actualizar">
                        <input type="hidden" name="idCargo" value="${cargo.idCargo}">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="accion" value="insertar">
                    </c:otherwise>
                </c:choose>

                <div class="mb-3">
                    <label class="form-label">Cargo</label>
                    <input
                        type="text"
                        name="cargo"
                        class="form-control"
                        value="${cargo.cargo}"
                        required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Descripción</label>
                    <textarea
                        name="descripcionCargo"
                        class="form-control"
                        rows="4">${cargo.descripcionCargo}</textarea>
                </div>

                <div class="mb-3 form-check">
                    <input
                        type="checkbox"
                        class="form-check-input"
                        id="jefatura"
                        name="jefatura"
                        <c:if test="${cargo != null && cargo.jefatura}">checked</c:if>>
                    <label class="form-check-label" for="jefatura">Es jefatura</label>
                </div>

                <button type="submit" class="btn btn-sistema me-2">
                    Guardar
                </button>

                <a href="CargoServlet?accion=listar" class="btn btn-volver">
                    Cancelar
                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>