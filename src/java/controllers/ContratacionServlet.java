package controllers;

import dao.ContratacionDAO;
import models.Contratacion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContratacionServlet")
public class ContratacionServlet extends HttpServlet {

    private final ContratacionDAO dao = new ContratacionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        try {
            switch (accion) {
                case "nuevo":
                    request.getRequestDispatcher("/views/contratacion/form.jsp").forward(request, response);
                    break;

                case "insertar": {
                    Contratacion c = new Contratacion();
                    c.setIdDepartamento(Integer.parseInt(request.getParameter("idDepartamento")));
                    c.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
                    c.setIdCargo(Integer.parseInt(request.getParameter("idCargo")));
                    c.setIdTipoContratacion(Integer.parseInt(request.getParameter("idTipoContratacion")));
                    // Aquí capturamos el valor del input date
                    c.setFechaContracion(request.getParameter("fechaContratacion")); 
                    c.setSalario(Double.parseDouble(request.getParameter("salario")));
                    c.setEstado(request.getParameter("estado") != null);
                    
                    dao.insertar(c);
                    response.sendRedirect("ContratacionServlet?accion=listar");
                    break;
                }

                case "eliminar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("ContratacionServlet?accion=listar");
                    break;
                }

                case "listar":
                default: {
                    List<Contratacion> lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("/views/contratacion/list.jsp").forward(request, response);
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