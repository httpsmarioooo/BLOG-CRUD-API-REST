package com.example.prueba.service;

import com.example.prueba.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPersonaService {
    List<Persona> obtenerTodos();
    Persona obtenerPorId (Long id);
    void guardarPersona(Persona persona);
    void deletePersona(Long id);                      // 👈 Eliminar persona por ID
    void updatePersona(Long id, Persona persona);
}