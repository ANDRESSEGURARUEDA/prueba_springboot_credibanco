package com.pruebaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCard {

    @JsonProperty ("status")
    private String status;

    @JsonProperty ("message")
    private String message;
    public Long numeroValidacion;
    public String pan;
    public String identificadorDelSisitema;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getNumeroValidacion() {
        return numeroValidacion;
    }

    public void setNumeroValidacion(Long numeroValidacion) {
        this.numeroValidacion = numeroValidacion;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getIdentificadorDelSisitema() {
        return identificadorDelSisitema;
    }

    public void setIdentificadorDelSisitema(String identificadorDelSisitema) {
        this.identificadorDelSisitema = identificadorDelSisitema;
    }
}
