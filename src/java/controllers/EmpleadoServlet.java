package controllers;

import dao.EmpleadoDAO;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Empleado;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

    // Instanciamos nuestro DAO para poder usarlo
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    // Este es el método clave que pide tu rúbrica
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtenemos la "acción" que el usuario quiere realizar (listar, guardar, eliminar...)
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar"; // Por defecto, mostramos la lista
        }

        switch (accion) {
            case "listar":
                listarEmpleados(request, response);
                break;
            case "nuevo":
                // Simplemente redirige a un formulario vacío
                request.getRequestDispatcher("views/empleado/form.jsp").forward(request, response);
                break;
            case "guardar":
                guardarEmpleado(request, response);
                break;
            case "eliminar":
                eliminarEmpleado(request, response);
                break;
            case "editar":
                cargarEmpleado(request, response);
                break;
            case "actualizar":
                actualizarEmpleado(request, response);
                break;
            default:
                listarEmpleados(request, response);
        }
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Pedimos los datos al DAO
        List<Empleado> lista = empleadoDAO.obtenerTodos();
        // 2. Guardamos la lista en el "request" para que la página web pueda leerla
        request.setAttribute("empleados", lista);
        // 3. Enviamos al usuario a la pantalla de la lista
        request.getRequestDispatcher("views/empleado/list.jsp").forward(request, response);
    }

    private void guardarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. Recibimos los datos del formulario web
        String dui = request.getParameter("numeroDui");
        String nombre = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String telefono = request.getParameter("numeroTelefono");
        String correo = request.getParameter("correoInstitucional");
        Date fechaNac = Date.valueOf(request.getParameter("fechaNacimiento")); // Convierte el texto a Fecha

        // 2. Creamos un objeto Empleado con esos datos
        Empleado emp = new Empleado(0, dui, nombre, usuario, telefono, correo, fechaNac);

        // 3. Lo guardamos usando el DAO
        empleadoDAO.insertar(emp);

        // 4. Redirigimos de vuelta a la lista para ver el nuevo empleado
        response.sendRedirect("EmpleadoServlet?accion=listar");
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        empleadoDAO.eliminar(id);
        response.sendRedirect("EmpleadoServlet?accion=listar");
    }
    private void cargarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Recibimos el ID del empleado que se quiere editar
        int id = Integer.parseInt(request.getParameter("id"));
        
        // 2. Buscamos sus datos en la base de datos usando el nuevo método del DAO
        Empleado emp = empleadoDAO.obtenerPorId(id);
        
        // 3. Guardamos los datos en el request para que la pantalla de edición pueda verlos
        request.setAttribute("empleado", emp);
        
        // 4. Lo enviamos a la pantalla de edición (que crearemos en el siguiente paso)
        request.getRequestDispatcher("views/empleado/edit.jsp").forward(request, response);
    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. Recibimos todos los datos del formulario (¡Incluyendo el ID oculto!)
        int id = Integer.parseInt(request.getParameter("idEmpleado"));
        String dui = request.getParameter("numeroDui");
        String nombre = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String telefono = request.getParameter("numeroTelefono");
        String correo = request.getParameter("correoInstitucional");
        Date fechaNac = Date.valueOf(request.getParameter("fechaNacimiento"));

        // 2. Creamos el objeto con los datos actualizados
        Empleado emp = new Empleado(id, dui, nombre, usuario, telefono, correo, fechaNac);

        // 3. Usamos el método actualizar del DAO (que ya habíamos programado antes)
        empleadoDAO.actualizar(emp);

        // 4. Redirigimos de vuelta a la lista
        response.sendRedirect("EmpleadoServlet?accion=listar");
    }

    // Tanto GET como POST se envían a processRequest, tal como pide el requerimiento
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