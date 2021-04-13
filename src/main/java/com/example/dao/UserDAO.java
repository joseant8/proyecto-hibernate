package com.example.dao;

import com.example.model.Task;
import com.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    public List<User> recuperarTodosLosUsuarios();

    public User recuperarUsuario(Long id);

    public List<User> recuperarTodosLosUsuariosActivos();

    public List<Task> recuperarTareasDelUsuario(Long id);

    public User crearUsuario(User usuario);

    public User actualizarUsuario(User usuario);


}
