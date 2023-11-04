package com.pruebaspringboot.entity;


import jakarta.persistence.*;

@Entity
@Table (name = "typeTarjeta")
public class TypeCardEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;


    @Column (name = "type_tarjeta")
    private String tipoTarjeta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

}
