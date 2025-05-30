package com.example.prueba.service;

import com.example.prueba.domain.Persona;

import java.util.List;

public interface IPersonaService {
    List<Persona> obtenerTodos();
    Persona obtenerPorId (Long id);
    void guardarPersona(Persona persona);

}