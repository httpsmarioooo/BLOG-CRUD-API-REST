package com.example.prueba.controller;

import com.example.prueba.domain.Comentario;
import com.example.prueba.domain.Persona;
import com.example.prueba.domain.Publicacion;
import com.example.prueba.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping("/ObtenerComentarios")
    public List<Comentario> listaComentarios(){
        return comentarioService.obtenerTodos();
    }

    @GetMapping("/buscar/{id}")
    public Comentario obtenerPorID(@PathVariable Long id){
        return comentarioService.obtenerPorId(id);
    }

    @PostMapping(value = "/crearComentario")
    public ResponseEntity<String> crearComentario(@RequestBody Comentario comentario) {
        comentarioService.crearComentario(comentario);
        return ResponseEntity.ok("Comentario agregada con éxito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable Long id) {
        comentarioService.deleteComentario(id);
        return ResponseEntity.ok("Comentario eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarComentario(@PathVariable Long id, @RequestBody Comentario comentarioActualizado) {
        comentarioService.updateComentario(id, comentarioActualizado);
        return ResponseEntity.ok("Comentario actualizado con éxito");
    }


}
