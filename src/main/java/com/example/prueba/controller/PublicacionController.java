package com.example.prueba.controller;

import com.example.prueba.domain.Publicacion;
import com.example.prueba.service.PublicacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

   private final PublicacionService publicacionService;

   public PublicacionController(PublicacionService publicacionService){
       this.publicacionService = publicacionService;
   }

    @GetMapping("/ObtenerPublicaciones")
    public List<Publicacion> listaPublicaciones(){
        return publicacionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Publicacion obtenerPorID(@PathVariable Long id){
        return publicacionService.obtenerPorId(id);
    }

    @PostMapping(value = "/guardarNuevaPublicacion")
    public ResponseEntity<String> guardarPublicacion(@RequestBody Publicacion publicacion) {
        publicacionService.guardarPublicacion(publicacion);
        return ResponseEntity.ok("Publicación agregada con éxito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.deletePublicacion(id);
        return ResponseEntity.ok("Publicación eliminada con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacionActualizada) {
        publicacionService.updatePublicacion(id, publicacionActualizada);
        return ResponseEntity.ok("Publicación actualizada con éxito");
    }
}
