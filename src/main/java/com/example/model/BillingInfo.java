package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class BillingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;

    private String telefono;

    @OneToOne(mappedBy = "facturacion")
    @JsonIgnore     // Para evitar en la respuesta json la recursión infinita en relaciones bidireccionales
    private User usuario;

    public BillingInfo() {
    }

    public BillingInfo(String direccion, String telefono) {
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Para evitar en la respuesta json la recursión infinita en relaciones bidireccionales, devolvemos únicamente el id del usuario
    public Long getUsuarioId() {
        return usuario.getId();
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "BillingInfo{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario.getNombre() +
                '}';
    }
}
