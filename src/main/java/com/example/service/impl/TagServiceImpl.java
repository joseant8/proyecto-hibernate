package com.example.service.impl;

import com.example.dao.TagDAO;
import com.example.model.Tag;
import com.example.model.Task;
import com.example.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public List<Tag> recuperarTodasLasEtiquetas() {
        return tagDAO.recuperarTodasLasEtiquetas();
    }

    @Override
    public Tag recuperarEtiqueta(Long id) {
        return tagDAO.recuperarEtiqueta(id);
    }

    @Override
    public Tag recuperarEtiquetaPorNombre(String nombre) {
        return tagDAO.recuperarEtiquetaPorNombre(nombre);
    }

    @Override
    public List<Task> recuperarTodasLasTareasConEtiqueta(Long id) {
        return tagDAO.recuperarTodasLasTareasConEtiqueta(id);
    }

    @Override
    public Tag crearEtiqueta(Tag tag) {
        return tagDAO.crearEtiqueta(tag);
    }

    @Override
    public Tag actualizarEtiqueta(Tag tag) {
        return tagDAO.actualizarEtiqueta(tag);
    }
}
