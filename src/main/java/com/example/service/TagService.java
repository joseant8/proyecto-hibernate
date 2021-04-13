package com.example.service;

import com.example.model.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> recuperarTodasLasEtiquetas();

    public Tag recuperarEtiqueta(Long id);

    public Tag recuperarEtiquetaPorNombre(String nombre);

    public Tag crearEtiqueta(Tag tag);

    public Tag actualizarEtiqueta(Tag tag);
}
