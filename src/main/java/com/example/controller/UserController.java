package com.example.controller;

import com.example.model.Task;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService servicio;

    public UserController(UserService servicio) {
        this.servicio = servicio;
    }


    // -----------------------------
    // Consultas
    // -----------------------------

    @GetMapping("/usuarios")
    public List<User> recuperarTodosLosUsuarios(){
        return servicio.recuperarTodosLosUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> recuperarUsuario(@PathVariable Long id){
        User usuario = servicio.recuperarUsuario(id);
        if(usuario != null){
            return ResponseEntity.ok().body(usuario);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/usuarios/activos")
    public List<User> recuperarTodosLosUsuariosActivos(){
        return servicio.recuerarTodosLosUsuariosActivos();
    }

    @GetMapping("/usuarios/tareas-pendientes/{id}")
    public List<Task> recuperarTareasPendientesDelUsuario(@PathVariable Long id){
        return servicio.recuperarTareasPendientesDelUsuario(id);
    }

    // -----------------------------
    // Crear
    // -----------------------------

    @PostMapping("/usuarios")
    public ResponseEntity<User> crearUsuario(@RequestBody User usuario) throws URISyntaxException {
        if(usuario.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User usuarioCreado = servicio.crearUsuario(usuario);
        return ResponseEntity.created(new URI("/api/usuarios/" + usuarioCreado.getId())).body(usuarioCreado);
    }

    // -----------------------------
    // Actualizar
    // -----------------------------

    @PutMapping("/usuarios")
    public ResponseEntity<User> actualizarUsuario(@RequestBody User usuario){
        if(usuario.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User usuarioActualizado = servicio.actualizarUsuario(usuario);
        return ResponseEntity.ok().body(usuarioActualizado);
    }

    // -----------------------------
    // Elimminar
    // -----------------------------

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        if(!servicio.eliminarUsuario(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.noContent().build();
    }



}
