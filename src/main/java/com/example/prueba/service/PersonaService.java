package com.example.prueba.service;

import com.example.prueba.domain.Persona;
import com.example.prueba.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}
