package controllers;

import dao.TipoContratacionDAO;
import models.TipoContratacion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TipoContratacionServlet")
public class TipoContratacionServlet extends HttpServlet {

    private final TipoContratacionDAO dao = new TipoContratacionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        try {
            switch (accion) {
                case "nuevo":
                    request.getRequestDispatcher("/views/tipoContratacion/form.jsp").forward(request, response);
                    break;

                case "insertar": {
                    String nombre = request.getParameter("tipoContratacion");
                    TipoContratacion tc = new TipoContratacion();
                    tc.setTipoContratacion(nombre);
                    dao.insertar(tc);
                    response.sendRedirect("TipoContratacionServlet?accion=listar");
                    break;
                }

                case "editar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    TipoContratacion tc = dao.buscarPorId(id);
                    request.setAttribute("tipoContratacion", tc);
                    request.getRequestDispatcher("/views/tipoContratacion/form.jsp").forward(request, response);
                    break;
                }

                case "actualizar": {
                    int id = Integer.parseInt(request.getParameter("idTipoContratacion"));
                    String nombre = request.getParameter("tipoContratacion");
                    TipoContratacion tc = new TipoContratacion(id, nombre);
                    dao.actualizar(tc);
                    response.sendRedirect("TipoContratacionServlet?accion=listar");
                    break;
                }

                case "eliminar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("TipoContratacionServlet?accion=listar");
                    break;
                }

                case "listar":
                default: {
                    List<TipoContratacion> lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("/views/tipoContratacion/list.jsp").forward(request, response);
                    break;
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Error en BD: " + e.getMessage(), e);
        }
    }

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}