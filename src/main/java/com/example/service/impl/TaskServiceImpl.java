package com.example.service.impl;

import com.example.dao.TaskDAO;
import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO;

    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> recuperarTodasLasTareas() { return taskDAO.recuperarTodasLasTareas(); }

    @Override
    public Task recuperarTarea(Long id) {
        return taskDAO.recuperarTarea(id);
    }

    @Override
    public List<Task> recuperarTodasLasTareasSinFinalizar() {
        return taskDAO.recuperarTodasLasTareasSinFinalizar();
    }

    @Override
    public Task crearTarea(Task tarea) {
        return taskDAO.crearTarea(tarea);
    }

    @Override
    public Task actualizarTarea(Task tarea) {
        return taskDAO.actualizarTarea(tarea);
    }
}
