package com.example.dao;

import com.example.model.Task;

import java.util.List;

public interface TaskDAO {

    public List<Task> recuperarTodasLasTareas();

    public Task recuperarTarea(Long id);

    public List<Task> recuperarTodasLasTareasSinFinalizar();

    public Task crearTarea(Task tarea);

    public Task actualizarTarea(Task tarea);
}
