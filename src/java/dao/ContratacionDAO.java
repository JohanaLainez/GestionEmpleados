package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Contratacion;
import utils.DBConnection;

public class ContratacionDAO {
    private Connection con;

    public List<Contratacion> listar() throws SQLException {
        List<Contratacion> lista = new ArrayList<>();
        String sql = "SELECT idContratacion, idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado FROM Contrataciones";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new Contratacion(
                rs.getInt("idContratacion"),
                rs.getInt("idDepartamento"),
                rs.getInt("idEmpleado"),
                rs.getInt("idCargo"),
                rs.getInt("idTipoContratacion"),
                rs.getString("fechaContratacion"),
                rs.getDouble("salario"),
                rs.getBoolean("estado")
            ));
        }
        return lista;
    }

    public void insertar(Contratacion c) throws SQLException {
        String sql = "INSERT INTO Contrataciones (idDepartamento, idEmpleado, idCargo, idTipoContratacion, fechaContratacion, salario, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, c.getIdDepartamento());
        ps.setInt(2, c.getIdEmpleado());
        ps.setInt(3, c.getIdCargo());
        ps.setInt(4, c.getIdTipoContratacion());
        ps.setString(5, c.getFechaContracion()); 
        ps.setDouble(6, c.getSalario());
        ps.setBoolean(7, c.isEstado());
        ps.executeUpdate();
    }
    
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Contrataciones WHERE idContratacion = ?";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}