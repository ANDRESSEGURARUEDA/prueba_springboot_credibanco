package com.pruebaspringboot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "numberReference", unique = true)
    public int numberReference;
    @Column(name = "fullPurchase")
    public double fullPurchase;
    @Column(name = "addres")
    public String addres;
    @Column (name = "statusTransaction")
    private String statusTransaction;
    @Column (name = "createdate")
    private LocalDateTime createDate;
    @Column (name = "lastmodifieddate")
    private LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
