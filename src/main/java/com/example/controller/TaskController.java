package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService servicio;

    public TaskController(TaskService servicio) {
        this.servicio = servicio;
    }


    // -----------------------------
    // Consultas
    // -----------------------------

    @GetMapping("tareas")
    public List<Task> recuperarTodasLasTareas(){
        return servicio.recuperarTodasLasTareas();
    }

    @GetMapping("tareas/{id}")
    public ResponseEntity<Task> recuperarTarea(@PathVariable Long id){
        Task tarea = servicio.recuperarTarea(id);
        if(tarea != null){
            return ResponseEntity.ok().body(tarea);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("tareas/pendientes")
    public List<Task> recuperarTodasLasTareasSinFinalizar(){
        return servicio.recuperarTodasLasTareasSinFinalizar();
    }

    // -----------------------------
    // Crear
    // -----------------------------

    @PostMapping("/tareas")
    public ResponseEntity<Task> crearTarea(@RequestBody Task tarea) throws URISyntaxException {
        if(tarea.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Task tareaCreada = servicio.crearTarea(tarea);
        return ResponseEntity.created(new URI("/api/tareas/" + tareaCreada.getId())).body(tareaCreada);
    }

    // -----------------------------
    // Actualizar
    // -----------------------------

    @PutMapping("/tareas")
    public ResponseEntity<Task> actualizarTarea(@RequestBody Task tarea){
        if(tarea.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Task tareaActualizada = servicio.actualizarTarea(tarea);
        return ResponseEntity.ok().body(tareaActualizada);
    }

}
