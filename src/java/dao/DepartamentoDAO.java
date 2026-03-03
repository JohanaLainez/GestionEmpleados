package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;
import utils.DBConnection;

public class DepartamentoDAO {

    public List<Departamento> listar() throws SQLException {
        String sql = "SELECT idDepartamento, nombreDepartamento, descripcionDepartamento FROM departamento ORDER BY idDepartamento DESC";
        List<Departamento> lista = new ArrayList<>();

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNombreDepartamento(rs.getString("nombreDepartamento"));
                d.setDescripcionDepartamento(rs.getString("descripcionDepartamento"));
                lista.add(d);
            }
        }
        return lista;
    }

    public void insertar(Departamento d) throws SQLException {
        String sql = "INSERT INTO Departamento(nombreDepartamento, descripcionDepartamento) VALUES (?, ?)";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, d.getNombreDepartamento());
            ps.setString(2, d.getDescripcionDepartamento());
            ps.executeUpdate();
        }
    }

    public Departamento buscarPorId(int id) throws SQLException {
        String sql = "SELECT idDepartamento, nombreDepartamento, descripcionDepartamento FROM departamento WHERE idDepartamento = ?";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Departamento(
                        rs.getInt("idDepartamento"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("descripcionDepartamento")
                    );
                }
            }
        }
        return null;
    }

    public void actualizar(Departamento d) throws SQLException {
        String sql = "UPDATE Departamento SET nombreDepartamento = ?, descripcionDepartamento = ? WHERE idDepartamento = ?";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, d.getNombreDepartamento());
            ps.setString(2, d.getDescripcionDepartamento());
            ps.setInt(3, d.getIdDepartamento());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM departamento WHERE idDepartamento = ?";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}