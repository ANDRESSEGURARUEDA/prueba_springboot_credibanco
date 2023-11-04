package com.pruebaspringboot.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table (name = "Card")
public class CardEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Long id;

    @Column (name = "validationNumber")
    private Long validationNumber;

    @Column (name = "hash")
    private String hash;

    @Column (name = "pan")
    private Long pan;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "cedula")
    private Long cedula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "type_card_entity_id")
    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    private TypeCardEntity tipoTarjeta;

    @Column (name = "celular")
    private Long celular;


    @Column (name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column (name = "ultimaModificacion")
    private LocalDateTime ultimaModificacion;

    private String estadoTarjetaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TypeCardEntity getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TypeCardEntity tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public String getEstadoTarjetaId() {
        return estadoTarjetaId;
    }

    public void setEstadoTarjetaId(String estadoTarjetaId) {
        this.estadoTarjetaId = estadoTarjetaId;
    }
}
