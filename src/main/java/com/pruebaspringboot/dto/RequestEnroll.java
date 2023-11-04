package com.pruebaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties (ignoreUnknown = true)
@JsonInclude (JsonInclude.Include.NON_NULL)
public class RequestEnroll {

    @JsonProperty ("validationNumber")
    public Long validationNumber;
    @JsonProperty ("hash")
    public String hash;

    public Long getValidationNumber() {
        return validationNumber;
    }

    public void setValidationNumber(Long validationNumber) {
        this.validationNumber = validationNumber;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
