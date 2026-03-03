package controllers;

import dao.DepartamentoDAO;
import models.Departamento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DepartamentoServlet")

public class DepartamentoServlet extends HttpServlet {

    private final DepartamentoDAO dao = new DepartamentoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        try {
            switch (accion) {
                case "nuevo":
                    request.getRequestDispatcher("/views/departamento/form.jsp").forward(request, response);
                    break;

                case "insertar": {
                    String nombre = request.getParameter("nombreDepartamento");
                    String desc = request.getParameter("descripcionDepartamento");

                    Departamento d = new Departamento();
                    d.setNombreDepartamento(nombre);
                    d.setDescripcionDepartamento(desc);

                    dao.insertar(d);
                    response.sendRedirect("DepartamentoServlet?accion=listar");
                    break;
                }

                case "editar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Departamento d = dao.buscarPorId(id);
                    request.setAttribute("departamento", d);
                    request.getRequestDispatcher("/views/departamento/form.jsp").forward(request, response);
                    break;
                }

                case "actualizar": {
                    int id = Integer.parseInt(request.getParameter("idDepartamento"));
                    String nombre = request.getParameter("nombreDepartamento");
                    String desc = request.getParameter("descripcionDepartamento");

                    Departamento d = new Departamento(id, nombre, desc);
                    dao.actualizar(d);
                    response.sendRedirect("DepartamentoServlet?accion=listar");
                    break;
                }

                case "eliminar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("DepartamentoServlet?accion=listar");
                    break;
                }

                case "listar":
                default: {
                    List<Departamento> lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("/views/departamento/list.jsp").forward(request, response);
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