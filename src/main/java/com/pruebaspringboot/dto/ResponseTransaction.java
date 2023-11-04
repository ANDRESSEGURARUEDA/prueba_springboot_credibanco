package com.pruebaspringboot.dto;

public class ResponseTransaction {

    public String statusCode;
    public String message;
    public String statusTransaction;
    public int numberReference;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public int getNumberReference() {
        return numberReference;
    }

    public void setNumberReference(int numberReference) {
        this.numberReference = numberReference;
    }
}
