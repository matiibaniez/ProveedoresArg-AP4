package com.proveedoresarg.model;

public class Proveedor {

    private int id;
    private String razonSocial;
    private String cuit;
    private String email;
    private String telefono;
    private String provincia;

    // Constructor vacío
    public Proveedor() {
    }

    // Constructor completo
    public Proveedor(String razonSocial, String cuit, String email, String telefono, String provincia) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.email = email;
        this.telefono = telefono;
        this.provincia = provincia;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    // Método de validación
    public void validarDatos() throws Exception {

        if (razonSocial == null || razonSocial.trim().isEmpty()) {
            throw new Exception("La razón social no puede estar vacía.");
        }

        if (cuit == null || !cuit.matches("\\d{11}")) {
            throw new Exception("El CUIT debe contener 11 números.");
        }

        if (email == null || !email.contains("@")) {
            throw new Exception("El email no es válido.");
        }

        if (telefono == null || !telefono.matches("\\d+")) {
            throw new Exception("El teléfono solo puede contener números.");
        }

        if (provincia == null || provincia.trim().isEmpty()) {
            throw new Exception("Debe seleccionar una provincia.");
        }
    }

    @Override
    public String toString() {
        return "\nProveedor {" +
                "ID = " + id +
                ", Razón Social = '" + razonSocial + '\'' +
                ", CUIT = '" + cuit + '\'' +
                ", Email = '" + email + '\'' +
                ", Teléfono = '" + telefono + '\'' +
                ", Provincia = '" + provincia + '\'' +
                "}";
    }
}

    

