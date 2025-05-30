package com.example.prueba.controller;

import com.example.prueba.domain.Persona;
import com.example.prueba.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;


    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping("/ObtenerPersonas")
    public List<Persona> listaPersonas(){
        return personaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Persona obtenerPorID(@PathVariable Long id){
        return personaService.obtenerPorId(id);
    }

    @PostMapping(value = "/guardarNuevaPersona")
    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona) {
        personaService.guardarPersona(persona);
        return ResponseEntity.ok("Persona agregada con éxito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.ok("Persona eliminada con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPersona(@PathVariable Long id, @RequestBody Persona personaActualizada) {
        personaService.updatePersona(id, personaActualizada);
        return ResponseEntity.ok("Persona actualizada con éxito");
    }

}




