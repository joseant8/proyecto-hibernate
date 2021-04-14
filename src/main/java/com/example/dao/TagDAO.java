package com.example.dao;

import com.example.model.Tag;
import com.example.model.Task;

import java.util.List;

public interface TagDAO {

    public List<Tag> recuperarTodasLasEtiquetas();

    public Tag recuperarEtiqueta(Long id);

    public Tag recuperarEtiquetaPorNombre(String nombre);

    public List<Task> recuperarTodasLasTareasConEtiqueta(Long id);

    public Tag crearEtiqueta(Tag tag);

    public Tag actualizarEtiqueta(Tag tag);
}
