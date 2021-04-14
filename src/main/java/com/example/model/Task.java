package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private boolean finalizada;

    private LocalDate fechaEntrega;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User usuario;

    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = {@JoinColumn(name="task_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id", referencedColumnName = "id")}
    )
    private List<Tag> tags = new ArrayList<>();


    public Task() {
    }

    public Task(String titulo, String descripcion, boolean finalizada, LocalDate fechaEntrega) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.finalizada = finalizada;
        this.fechaEntrega = fechaEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    // Para evitar en la respuesta json la recursión infinita en relaciones bidireccionales, devolvemos el id del usuario
    public Long getUsuarioId() {
        return usuario.getId();
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", finalizada=" + finalizada +
                ", fechaEntrega=" + fechaEntrega +
                ", usuario=" + usuario.getNombre() +
                ", num_tags=" + tags.size() +
                '}';
    }
}
