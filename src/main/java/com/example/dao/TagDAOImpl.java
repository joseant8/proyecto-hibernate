package com.example.dao;

import com.example.model.Tag;
import com.example.repository.TagRepository;
import org.hibernate.Session;
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
    private Session session;

    @Autowired
    private TagRepository repository;

    /**
     * Recupera todas las etiquetas utilizando Session de Hibernate
     * @return
     */
    @Override
    public List<Tag> recuperarTodasLasEtiquetas() {
        return session.createQuery("from Tag", Tag.class).list();
    }

    /**
     * recupera una etiqueta por su id utilizando Session de Hibernate
     * @param id
     * @return
     */
    @Override
    public Tag recuperarEtiqueta(Long id) {
        return session.find(Tag.class, id);
    }

    /**
     * recupera una etiqueta según el nombre
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
