package controllers;

import dao.CargoDAO;
import models.Cargo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CargoServlet")
public class CargoServlet extends HttpServlet {

    private final CargoDAO dao = new CargoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        try {
            switch (accion) {

                case "nuevo":
                    request.getRequestDispatcher("/views/cargos/form.jsp").forward(request, response);
                    break;

                case "insertar": {
                    String nombreCargo = request.getParameter("cargo");
                    String descripcionCargo = request.getParameter("descripcionCargo");
                    boolean jefatura = request.getParameter("jefatura") != null;

                    Cargo c = new Cargo();
                    c.setCargo(nombreCargo);
                    c.setDescripcionCargo(descripcionCargo);
                    c.setJefatura(jefatura);

                    dao.insertar(c);
                    response.sendRedirect("CargoServlet?accion=listar");
                    break;
                }

                case "editar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Cargo c = dao.buscarPorId(id);

                    request.setAttribute("cargo", c);
                    request.getRequestDispatcher("/views/cargos/form.jsp").forward(request, response);
                    break;
                }

                case "actualizar": {
                    int id = Integer.parseInt(request.getParameter("idCargo"));
                    String nombreCargo = request.getParameter("cargo");
                    String descripcionCargo = request.getParameter("descripcionCargo");
                    boolean jefatura = request.getParameter("jefatura") != null;

                    Cargo c = new Cargo();
                    c.setIdCargo(id);
                    c.setCargo(nombreCargo);
                    c.setDescripcionCargo(descripcionCargo);
                    c.setJefatura(jefatura);

                    dao.actualizar(c);
                    response.sendRedirect("CargoServlet?accion=listar");
                    break;
                }

                case "eliminar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("CargoServlet?accion=listar");
                    break;
                }

                case "listar":
                default: {
                    List<Cargo> lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("/views/cargos/list.jsp").forward(request, response);
                    break;
                }
            }

        } catch (SQLException e) {
    throw new ServletException("Error en BD: " + e.getMessage(), e);
}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}