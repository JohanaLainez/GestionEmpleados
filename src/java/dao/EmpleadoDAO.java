package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;
import utils.DBConnection; // Asumiendo que esta es la clase que tienen para la conexión

public class EmpleadoDAO {

    // Método para LISTAR todos los empleados
    public List<Empleado> obtenerTodos() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        // Consulta SQL limpia
        String sql = "SELECT * FROM Empleados"; 

        // El bloque try-with-resources cierra automáticamente las conexiones
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorremos los resultados de la base de datos
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt("idEmpleado"));
                emp.setNumeroDui(rs.getString("numeroDui"));
                emp.setNombrePersona(rs.getString("nombrePersona"));
                emp.setUsuario(rs.getString("usuario"));
                emp.setNumeroTelefono(rs.getString("numeroTelefono"));
                emp.setCorreoInstitucional(rs.getString("correoInstitucional"));
                emp.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                
                // Añadimos el empleado a nuestra lista
                listaEmpleados.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        return listaEmpleados;
    }

    // Método para INSERTAR un nuevo empleado
    public boolean insertar(Empleado emp) {
        // Consulta PARAMETRIZADA con ? para seguridad
        String sql = "INSERT INTO Empleados (numeroDui, nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Asignamos los valores a los signos de interrogación
            ps.setString(1, emp.getNumeroDui());
            ps.setString(2, emp.getNombrePersona());
            ps.setString(3, emp.getUsuario());
            ps.setString(4, emp.getNumeroTelefono());
            ps.setString(5, emp.getCorreoInstitucional());
            ps.setDate(6, emp.getFechaNacimiento());
            
            // Si executeUpdate devuelve más de 0, significa que se insertó correctamente
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }
    
    // Método para ACTUALIZAR un empleado existente
    public boolean actualizar(Empleado emp) {
        // Usamos ? para evitar inyección SQL
        String sql = "UPDATE Empleados SET numeroDui=?, nombrePersona=?, usuario=?, numeroTelefono=?, correoInstitucional=?, fechaNacimiento=? WHERE idEmpleado=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Llenamos los datos en el mismo orden que los signos de interrogación
            ps.setString(1, emp.getNumeroDui());
            ps.setString(2, emp.getNombrePersona());
            ps.setString(3, emp.getUsuario());
            ps.setString(4, emp.getNumeroTelefono());
            ps.setString(5, emp.getCorreoInstitucional());
            ps.setDate(6, emp.getFechaNacimiento());
            ps.setInt(7, emp.getIdEmpleado()); // El ID va al final para el WHERE
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para ELIMINAR un empleado
    public boolean eliminar(int idEmpleado) {
        String sql = "DELETE FROM Empleados WHERE idEmpleado=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idEmpleado);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }
    // Método para OBTENER UN EMPLEADO por su ID (Sirve para llenar el formulario de edición)
    public Empleado obtenerPorId(int id) {
        Empleado emp = null;
        String sql = "SELECT * FROM Empleados WHERE idEmpleado=?"; // Consulta parametrizada
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id); // Le pasamos el ID que queremos buscar
            
            try (ResultSet rs = ps.executeQuery()) {
                // Si encontramos al empleado, llenamos el objeto
                if (rs.next()) {
                    emp = new Empleado();
                    emp.setIdEmpleado(rs.getInt("idEmpleado"));
                    emp.setNumeroDui(rs.getString("numeroDui"));
                    emp.setNombrePersona(rs.getString("nombrePersona"));
                    emp.setUsuario(rs.getString("usuario"));
                    emp.setNumeroTelefono(rs.getString("numeroTelefono"));
                    emp.setCorreoInstitucional(rs.getString("correoInstitucional"));
                    emp.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el empleado: " + e.getMessage());
        }
        return emp; // Devolvemos el empleado con sus datos listos
    }
}