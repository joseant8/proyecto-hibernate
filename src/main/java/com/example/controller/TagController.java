package com.example.controller;

import com.example.model.Tag;
import com.example.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

    private TagService servicio;

    public TagController(TagService servicio) {
        this.servicio = servicio;
    }

    // -----------------------------
    // Consultas
    // -----------------------------

    @GetMapping("etiquetas")
    public List<Tag> recuperarTodasLasEtiquetas(){
        return servicio.recuperarTodasLasEtiquetas();
    }

    @GetMapping("etiquetas/{id}")
    public ResponseEntity<Tag> recuperarEtiqueta(@PathVariable Long id){
        Tag tag = servicio.recuperarEtiqueta(id);
        if(tag != null){
            return ResponseEntity.ok().body(tag);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("etiquetas/nombre/{nombre}")
    public ResponseEntity<Tag> recuperarEtiquetaPorNombre(@PathVariable String nombre){
        Tag tag = servicio.recuperarEtiquetaPorNombre(nombre);
        if(tag != null){
            return ResponseEntity.ok().body(tag);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // -----------------------------
    // Crear
    // -----------------------------

    @PostMapping("/etiquetas")
    public ResponseEntity<Tag> crearEtiqueta(@RequestBody Tag tag) throws URISyntaxException {
        if(tag.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Tag tagCreada = servicio.crearEtiqueta(tag);
        return ResponseEntity.created(new URI("/api/etiquetas/" + tagCreada.getId())).body(tagCreada);
    }

    // -----------------------------
    // Actualizar
    // -----------------------------

    @PutMapping("/etiquetas")
    public ResponseEntity<Tag> actualizarEtiqueta(@RequestBody Tag tag){
        if(tag.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Tag tagActualizada = servicio.actualizarEtiqueta(tag);
        return ResponseEntity.ok().body(tagActualizada);
    }


}
