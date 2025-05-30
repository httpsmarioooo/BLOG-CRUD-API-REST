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

}




