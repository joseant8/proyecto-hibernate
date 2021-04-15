package com.example.dao;

import com.example.model.Task;
import com.example.model.User;
import com.example.repository.UserRepository;
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
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Session session;

    @Autowired
    private UserRepository repository;


    /**
     * recupera todos los usuarios utilizando EntityManager
     * @return
     */
    @Override
    public List<User> recuperarTodosLosUsuarios() {
        List<User> lista = manager.createQuery("from User", User.class).getResultList();
        return lista;
    }

    /**
     * recupera un usuario por su id utilizando EntityManager
     * @param id
     * @return
     */
    @Override
    public User recuperarUsuario(Long id) {
        User userDB = manager.find(User.class, id);
        return userDB;
    }

    /**
     * recupera todos los usuarios activos utilizando criteria con EntityManager
     * @return
     */
    @Override
    public List<User> recuperarTodosLosUsuariosActivos() {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.where(builder.equal(root.get("activo"), true));

        return manager.createQuery(criteria).getResultList();
    }

    /**
     * recupera las tareas pendientes (sin finalizar) de un usuario utilizando EntityManager
     * @param id
     * @return
     */
    @Override
    public List<Task> recuperarTareasPendientesDelUsuario(Long id) {
        return manager.createQuery("select t from Task t where t.usuario = " + id + " and t.finalizada = false").getResultList();
    }

    /**
     * crea un nuevo usuario utilizando el repositorio
     * @param usuario
     * @return
     */
    @Override
    public User crearUsuario(User usuario) {
        return repository.save(usuario);
    }

    /**
     * actualiza un usuario utilizando el repositorio
     * @param usuario
     * @return
     */
    @Override
    public User actualizarUsuario(User usuario) {
        return repository.save(usuario);
    }

    /**
     * Elimina un usuario utilizando Session de Hibernate.
     * @param id
     * @return true si se ha eliminado el usuario y false si no ha encontrado dicho usuario
     */
    @Override
    public boolean eliminarUsuario(Long id) {
        User usuarioDB = session.get(User.class, id);
        if(usuarioDB == null){
            return false;
        }else{
            session.beginTransaction();
            session.delete(usuarioDB);
            session.getTransaction().commit();
            return true;
        }
    }
}
