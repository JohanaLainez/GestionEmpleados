package models;

import java.sql.Date;

public class Empleado {
    // 1. Declaración de variables (idénticas a los campos de tu base de datos)
    private int idEmpleado;
    private String numeroDui;
    private String nombrePersona;
    private String usuario;
    private String numeroTelefono;
    private String correoInstitucional;
    private Date fechaNacimiento;

    // 2. Constructor vacío (Buenas prácticas para POJOs)
    public Empleado() {
    }

    // 3. Constructor con todos los parámetros (útil para crear objetos rápidamente)
    public Empleado(int idEmpleado, String numeroDui, String nombrePersona, String usuario, String numeroTelefono, String correoInstitucional, Date fechaNacimiento) {
        this.idEmpleado = idEmpleado;
        this.numeroDui = numeroDui;
        this.nombrePersona = nombrePersona;
        this.usuario = usuario;
        this.numeroTelefono = numeroTelefono;
        this.correoInstitucional = correoInstitucional;
        this.fechaNacimiento = fechaNacimiento;
    }

    // 4. Getters y Setters (Para acceder y modificar los datos de forma segura)
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNumeroDui() { return numeroDui; }
    public void setNumeroDui(String numeroDui) { this.numeroDui = numeroDui; }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getCorreoInstitucional() { return correoInstitucional; }
    public void setCorreoInstitucional(String correoInstitucional) { this.correoInstitucional = correoInstitucional; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}