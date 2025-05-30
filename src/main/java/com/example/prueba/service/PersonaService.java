package com.example.prueba.service;

import com.example.prueba.domain.Persona;
import com.example.prueba.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaService implements IPersonaService {

    private final IPersonaRepository personaRepository;

    @Autowired
    public PersonaService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> obtenerTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarPersona(Persona persona) {
        personaRepository.save(persona);
    }


    @Override
    public void deletePersona(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new RuntimeException("La persona con ID " + id + " no existe");
        }
        personaRepository.deleteById(id);
    }

    @Override
    public void updatePersona(Long id, Persona personaActualizada) {
        Optional<Persona> personaExistente = personaRepository.findById(id);
        if (personaExistente.isPresent()) {
            Persona persona = personaExistente.get();
            persona.setNombre(personaActualizada.getNombre());
            persona.setCargo(personaActualizada.getCargo());
            personaRepository.save(persona);
        } else {
            throw new RuntimeException("La persona con ID " + id + " no existe");
        }
    }
}
