package com.proveedoresarg;

import com.proveedoresarg.controller.ProveedorController;
import com.proveedoresarg.dao.ProveedorDAO;
import com.proveedoresarg.view.ProveedorView;

public class Main {

    public static void main(String[] args) {

        // Instanciamos las dependencias
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        ProveedorController controller = new ProveedorController(proveedorDAO);
        ProveedorView view = new ProveedorView(controller);

        // Ejecutamos el menú principal
        view.mostrarMenu();
    }
}
