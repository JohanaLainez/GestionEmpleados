package dao;

import models.Cargo;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    // LISTAR
    public List<Cargo> listar() throws SQLException {

        List<Cargo> lista = new ArrayList<>();

        String sql = "SELECT * FROM cargos";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cargo c = new Cargo();

                c.setIdCargo(rs.getInt("idCargo"));
                c.setCargo(rs.getString("cargo"));
                c.setDescripcionCargo(rs.getString("descripcionCargo"));
                c.setJefatura(rs.getBoolean("jefatura"));

                lista.add(c);
            }
        }

        return lista;
    }

    // BUSCAR POR ID
    public Cargo buscarPorId(int id) throws SQLException {

        Cargo c = null;

        String sql = "SELECT * FROM cargos WHERE idCargo = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    c = new Cargo();

                    c.setIdCargo(rs.getInt("idCargo"));
                    c.setCargo(rs.getString("cargo"));
                    c.setDescripcionCargo(rs.getString("descripcionCargo"));
                    c.setJefatura(rs.getBoolean("jefatura"));
                }
            }
        }

        return c;
    }

    // INSERTAR
    public void insertar(Cargo c) throws SQLException {

        String sql = "INSERT INTO cargos (cargo, descripcionCargo, jefatura) VALUES (?, ?, ?)";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getCargo());
            ps.setString(2, c.getDescripcionCargo());
            ps.setBoolean(3, c.isJefatura());

            ps.executeUpdate();
        }
    }

    // ACTUALIZAR
    public void actualizar(Cargo c) throws SQLException {

        String sql = "UPDATE cargos SET cargo=?, descripcionCargo=?, jefatura=? WHERE idCargo=?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getCargo());
            ps.setString(2, c.getDescripcionCargo());
            ps.setBoolean(3, c.isJefatura());
            ps.setInt(4, c.getIdCargo());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM cargos WHERE idCargo = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}