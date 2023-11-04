package com.pruebaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseEnroll {

    @JsonProperty ("status")
    private String status;

    @JsonProperty ("message")
    private String message;

    @JsonProperty ("pan")
    private String pan;

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

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
