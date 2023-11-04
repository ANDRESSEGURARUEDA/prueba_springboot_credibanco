package com.pruebaspringboot.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "statusCard")
public class StatusCard {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;


    @Column(name = "status")
    private String estadoTarjeta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(String estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }


}
