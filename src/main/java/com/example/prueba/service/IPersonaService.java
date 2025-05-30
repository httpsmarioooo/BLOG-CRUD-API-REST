package com.example.prueba.service;

import com.example.prueba.domain.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> obtenerTodos();
    Persona obtenerPorId (Long id);
    void guardarPersona(Persona persona);
    void deletePersona(Long id);                      // 👈 Eliminar persona por ID
    void updatePersona(Long id, Persona persona);
}