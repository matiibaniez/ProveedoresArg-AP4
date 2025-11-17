package com.proveedoresarg.dao;

import com.proveedoresarg.db.ConexionDB;
import com.proveedoresarg.model.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO implements IProveedorDAO {

    @Override
    public void crear(Proveedor proveedor) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionDB.conectar();

            String sql = "INSERT INTO proveedores (razon_social, cuit, email, telefono, provincia) " +
                         "VALUES (?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, proveedor.getRazonSocial());
            stmt.setString(2, proveedor.getCuit());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getTelefono());
            stmt.setString(5, proveedor.getProvincia());

            int filas = stmt.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se pudo insertar el proveedor en la base de datos.");
            }

            // Obtener el ID generado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                proveedor.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new Exception("Error al crear proveedor: " + e.getMessage(), e);
        } finally {
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException ignored) {}
            }
            ConexionDB.cerrar(conn);
        }
    }

    @Override
    public List<Proveedor> buscarPorNombre(String nombre) throws Exception {
        List<Proveedor> resultados = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.conectar();

            String sql = "SELECT id_proveedor, razon_social, cuit, email, telefono, provincia " +
                         "FROM proveedores " +
                         "WHERE razon_social LIKE ? " +
                         "ORDER BY razon_social";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nombre + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId(rs.getInt("id_proveedor"));
                p.setRazonSocial(rs.getString("razon_social"));
                p.setCuit(rs.getString("cuit"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setProvincia(rs.getString("provincia"));
                resultados.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("Error al buscar proveedores por nombre: " + e.getMessage(), e);
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException ignored) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException ignored) {}
            }
            ConexionDB.cerrar(conn);
        }

        return resultados;
    }

    @Override
    public List<Proveedor> obtenerTodos() throws Exception {
        List<Proveedor> resultados = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.conectar();

            String sql = "SELECT id_proveedor, razon_social, cuit, email, telefono, provincia " +
                         "FROM proveedores " +
                         "ORDER BY razon_social";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId(rs.getInt("id_proveedor"));
                p.setRazonSocial(rs.getString("razon_social"));
                p.setCuit(rs.getString("cuit"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setProvincia(rs.getString("provincia"));
                resultados.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("Error al obtener todos los proveedores: " + e.getMessage(), e);
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException ignored) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException ignored) {}
            }
            ConexionDB.cerrar(conn);
        }

        return resultados;
    }
}
