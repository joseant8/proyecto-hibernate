package com.example.service.impl;

import com.example.dao.UserDAO;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> recuperarTodosLosUsuarios() {
        return userDAO.recuperarTodosLosUsuarios();
    }

    @Override
    public User recuperarUsuario(Long id) {
        return userDAO.recuperarUsuario(id);
    }

    @Override
    public List<User> recuerarTodosLosUsuariosActivos() {
        return userDAO.recuperarTodosLosUsuariosActivos();
    }

    @Override
    public List<Task> recuperarTareasPendientesDelUsuario(Long id) {
        return userDAO.recuperarTareasPendientesDelUsuario(id);
    }

    @Override
    public User crearUsuario(User usuario) {
        return userDAO.crearUsuario(usuario);
    }

    @Override
    public User actualizarUsuario(User usuario) {
        return userDAO.actualizarUsuario(usuario);
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        return userDAO.eliminarUsuario(id);
    }
}
