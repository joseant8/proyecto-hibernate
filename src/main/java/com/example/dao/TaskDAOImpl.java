package com.example.dao;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TaskRepository repository;

    /**
     * Recupera todas las tareas utilizando EntityManager
     * @return
     */
    @Override
    public List<Task> recuperarTodasLasTareas() {
        return manager.createQuery("from Task", Task.class).getResultList();
    }

    /**
     * recupera una tarea por su id utilizando EntityManager
     * @param id
     * @return
     */
    @Override
    public Task recuperarTarea(Long id) {
        return manager.find(Task.class, id);
    }

    /**
     * recupera todos las tareas sin finalizar utilizando criteria con EntityManager
     * @return
     */
    @Override
    public List<Task> recuperarTodasLasTareasSinFinalizar() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Task> criteria = builder.createQuery(Task.class);
        Root<Task> root = criteria.from(Task.class);

        criteria.where(builder.equal(root.get("finalizada"), false));

        return manager.createQuery(criteria).getResultList();
    }

    /**
     * Crea una nueva tarea utilizando el repositorio
     * @param tarea
     * @return
     */
    @Override
    public Task crearTarea(Task tarea) {
        return repository.save(tarea);
    }

    /**
     * Actualiza una tarea utilizando el repositorio
     * @param tarea
     * @return
     */
    @Override
    public Task actualizarTarea(Task tarea) {
        return repository.save(tarea);
    }
}
