package com.proveedoresarg.controller;

import com.proveedoresarg.dao.IProveedorDAO;
import com.proveedoresarg.model.Proveedor;

import java.util.List;

public class ProveedorController {

    private final IProveedorDAO proveedorDAO;

    // Inyectamos el DAO por constructor (buena práctica)
    public ProveedorController(IProveedorDAO proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }

    /**
     * Alta de proveedor.
     * Valida los datos y delega al DAO la persistencia.
     */
    public void altaProveedor(Proveedor proveedor) throws Exception {
        try {
            // Validación de negocio
            proveedor.validarDatos();

            // Persistencia
            proveedorDAO.crear(proveedor);

        } catch (Exception e) {
            // Propago la excepción para que la vista decida qué mensaje mostrar
            throw new Exception("No se pudo dar de alta el proveedor: " + e.getMessage(), e);
        }
    }

    /**
     * Búsqueda de proveedores por nombre (razón social).
     */
    public List<Proveedor> buscarProveedoresPorNombre(String nombre) throws Exception {
        try {
            return proveedorDAO.buscarPorNombre(nombre);
        } catch (Exception e) {
            throw new Exception("Error al buscar proveedores por nombre: " + e.getMessage(), e);
        }
    }

    /**
     * Listado de todos los proveedores.
     */
    public List<Proveedor> listarProveedores() throws Exception {
        try {
            return proveedorDAO.obtenerTodos();
        } catch (Exception e) {
            throw new Exception("Error al listar los proveedores: " + e.getMessage(), e);
        }
    }
}
