package com.pruebaspringboot.dto;

public class ResponseSearchCard {

    public String pan;
    public String nombre;
    public String apellido;
    public Long cedula;
    public Long celular;
    public String estadoTarjetaId;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEstadoTarjetaId() {
        return estadoTarjetaId;
    }

    public void setEstadoTarjetaId(String estadoTarjetaId) {
        this.estadoTarjetaId = estadoTarjetaId;
    }
}
