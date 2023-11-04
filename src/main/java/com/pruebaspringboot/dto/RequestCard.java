package com.pruebaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties (ignoreUnknown = true)
@JsonInclude (JsonInclude.Include.NON_NULL)
public class RequestCard {
    @JsonProperty ("pan")
    public Long pan;
    @JsonProperty ("nombre")
    public String nombre;
    @JsonProperty ("apellido")
    public String apellido;
    @JsonProperty ("cedula")
    public Long cedula;
    @JsonProperty ("tipoTarjeta")
    public Long tipoTarjeta;
    @JsonProperty ("celular")
    public Long celular;
    @JsonProperty ("estadoTarjetaId")
    public Long estadoTarjetaId;

    public Long getPan() {
        return pan;
    }

    public void setPan(Long pan) {
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

    public Long getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(Long tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Long getEstadoTarjetaId() {
        return estadoTarjetaId;
    }

    public void setEstadoTarjetaId(Long estadoTarjetaId) {
        this.estadoTarjetaId = estadoTarjetaId;
    }
}
