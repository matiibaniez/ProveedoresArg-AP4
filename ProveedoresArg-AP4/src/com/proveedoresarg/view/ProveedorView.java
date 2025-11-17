package com.proveedoresarg.view;

import com.proveedoresarg.controller.ProveedorController;
import com.proveedoresarg.model.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProveedorView {

    private final ProveedorController controller;
    private final Scanner scanner;

    // Array de provincias (uso de arreglos)
    private final String[] PROVINCIAS = {
            "Buenos Aires",
            "CABA",
            "Córdoba",
            "Santa Fe",
            "Mendoza",
            "Entre Ríos",
            "San Luis",
            "Otra"
    };

    public ProveedorView(ProveedorController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("\n===== ProveedoresArg - Gestión de Proveedores =====");
            System.out.println("1. Alta de proveedor");
            System.out.println("2. Buscar proveedor por nombre");
            System.out.println("3. Listar todos los proveedores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        altaProveedor();
                        break;
                    case 2:
                        buscarProveedorPorNombre();
                        break;
                    case 3:
                        listarProveedores();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }

    private void altaProveedor() {
        try {
            System.out.println("\n--- Alta de Proveedor ---");

            System.out.print("Razón social: ");
            String razonSocial = scanner.nextLine();

            System.out.print("CUIT (11 números, sin guiones): ");
            String cuit = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Teléfono (solo números): ");
            String telefono = scanner.nextLine();

            String provincia = seleccionarProvincia();

            Proveedor proveedor = new Proveedor(razonSocial, cuit, email, telefono, provincia);

            controller.altaProveedor(proveedor);

            System.out.println("Proveedor dado de alta correctamente.");
            System.out.println(proveedor);

        } catch (Exception e) {
            System.out.println("Error en el alta: " + e.getMessage());
        }
    }

    private String seleccionarProvincia() {
        System.out.println("\nSeleccione la provincia:");

        // Uso del arreglo PROVINCIAS
        for (int i = 0; i < PROVINCIAS.length; i++) {
            System.out.println((i + 1) + ". " + PROVINCIAS[i]);
        }

        int opcion = -1;
        while (opcion < 1 || opcion > PROVINCIAS.length) {
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > PROVINCIAS.length) {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }

        return PROVINCIAS[opcion - 1];
    }

    private void buscarProveedorPorNombre() {
        try {
            System.out.println("\n--- Búsqueda de Proveedores por Nombre ---");
            System.out.print("Ingrese parte del nombre o razón social: ");
            String nombre = scanner.nextLine();

            List<Proveedor> resultados = controller.buscarProveedoresPorNombre(nombre);

            if (resultados.isEmpty()) {
                System.out.println("No se encontraron proveedores con ese criterio.");
            } else {
                System.out.println("\nProveedores encontrados:");
                // Uso de ArrayList / List
                for (Proveedor p : resultados) {
                    System.out.println(p);
                }
            }

        } catch (Exception e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
        }
    }

    private void listarProveedores() {
        try {
            System.out.println("\n--- Listado de Proveedores ---");

            List<Proveedor> lista = controller.listarProveedores();

            if (lista.isEmpty()) {
                System.out.println("No hay proveedores registrados.");
            } else {
                for (Proveedor p : lista) {
                    System.out.println(p);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }
    }
}
