package models;

import java.util.Date;

public class Contratacion {
    private int idContratacion;
    private int idDepartamento;
    private int idEmpleado;
    private int idCargo;
    private int idTipoContratacion;
    private String fechaContracion; // Usamos String para simplificar el manejo en formularios HTML5
    private double salario;
    private boolean estado;

    public Contratacion() {}

    public Contratacion(int idContratacion, int idDepartamento, int idEmpleado, int idCargo, int idTipoContratacion, String fechaContracion, double salario, boolean estado) {
        this.idContratacion = idContratacion;
        this.idDepartamento = idDepartamento;
        this.idEmpleado = idEmpleado;
        this.idCargo = idCargo;
        this.idTipoContratacion = idTipoContratacion;
        this.fechaContracion = fechaContracion;
        this.salario = salario;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdContratacion() { return idContratacion; }
    public void setIdContratacion(int idContratacion) { this.idContratacion = idContratacion; }
    public int getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(int idDepartamento) { this.idDepartamento = idDepartamento; }
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    public int getIdCargo() { return idCargo; }
    public void setIdCargo(int idCargo) { this.idCargo = idCargo; }
    public int getIdTipoContratacion() { return idTipoContratacion; }
    public void setIdTipoContratacion(int idTipoContratacion) { this.idTipoContratacion = idTipoContratacion; }
    public String getFechaContracion() { return fechaContracion; }
    public void setFechaContracion(String fechaContracion) { this.fechaContracion = fechaContracion; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}