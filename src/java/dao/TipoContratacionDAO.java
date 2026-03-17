package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.TipoContratacion;
import utils.DBConnection;

public class TipoContratacionDAO {
    private Connection con;

    public List<TipoContratacion> listar() throws SQLException {
        List<TipoContratacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM TipoContratacion";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new TipoContratacion(rs.getInt("idTipoContratacion"), rs.getString("tipoContratacion")));
        }
        return lista;
    }

    public void insertar(TipoContratacion tc) throws SQLException {
        String sql = "INSERT INTO TipoContratacion (tipoContratacion) VALUES (?)";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tc.getTipoContratacion());
        ps.executeUpdate();
    }

    public TipoContratacion buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM TipoContratacion WHERE idTipoContratacion = ?";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new TipoContratacion(rs.getInt("idTipoContratacion"), rs.getString("tipoContratacion"));
        }
        return null;
    }

    public void actualizar(TipoContratacion tc) throws SQLException {
        String sql = "UPDATE TipoContratacion SET tipoContratacion = ? WHERE idTipoContratacion = ?";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tc.getTipoContratacion());
        ps.setInt(2, tc.getIdTipoContratacion());
        ps.executeUpdate();
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM TipoContratacion WHERE idTipoContratacion = ?";
        con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}