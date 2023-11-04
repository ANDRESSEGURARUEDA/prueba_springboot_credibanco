package com.pruebaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties (ignoreUnknown = true)
@JsonInclude (JsonInclude.Include.NON_NULL)
public class RequestCancelTransactions {

    @JsonProperty ("hash")
    public String hash;
    @JsonProperty ("numberReference")
    public int numberReference;
    @JsonProperty ("fullPurchase")
    public double fullPurchase;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNumberReference() {
        return numberReference;
    }

    public void setNumberReference(int numberReference) {
        this.numberReference = numberReference;
    }

    public double getFullPurchase() {
        return fullPurchase;
    }

    public void setFullPurchase(double fullPurchase) {
        this.fullPurchase = fullPurchase;
    }
}
