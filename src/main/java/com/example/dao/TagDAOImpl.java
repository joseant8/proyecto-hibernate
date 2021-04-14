package com.example.dao;

import com.example.model.Tag;
import com.example.model.Task;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TagRepository repository;

    /**
     * Recupera todas las etiquetas utilizando EntityManager
     * @return
     */
    @Override
    public List<Tag> recuperarTodasLasEtiquetas() {
        List<Tag> lista = manager.createQuery("from Tag", Tag.class).getResultList();
        return lista;
    }

    /**
     * recupera una etiqueta por su id utilizando EntityManager
     * @param id
     * @return
     */
    @Override
    public Tag recuperarEtiqueta(Long id) {
        return manager.find(Tag.class, id);
    }

    /**
     * recupera una etiqueta según el nombre utilizando criteria con EntityManager
     * @param nombre
     * @return
     */
    @Override
    public Tag recuperarEtiquetaPorNombre(String nombre) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);

        criteria.where(builder.equal(root.get("nombre"), nombre));

        try{
            Tag tareaDB = manager.createQuery(criteria).getSingleResult();
            return tareaDB;
        }catch (RuntimeException e){
            return null;
        }
    }

    /**
     * recupera todas las tareas con la etiqueta pasada por parámetro
     * @param id de la etiqueta
     * @return
     */
    @Override
    public List<Task> recuperarTodasLasTareasConEtiqueta(Long id) {
        Tag tag = manager.find(Tag.class, id);
        return tag.getTareas();
    }

    /**
     * Crea una nueva etiqueta utilizando el repositorio
     * @param tag
     * @return
     */
    @Override
    public Tag crearEtiqueta(Tag tag) {
        return repository.save(tag);
    }

    /**
     * Actualiza una etiqueta utilizando el repositorio
     * @param tag
     * @return
     */
    @Override
    public Tag actualizarEtiqueta(Tag tag) {
        return repository.save(tag);
    }
}
