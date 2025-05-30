package com.example.prueba.service;

import com.example.prueba.domain.Publicacion;

import java.util.List;

public interface IPublicacionService {
    List<Publicacion> obtenerTodos();
    Publicacion obtenerPorId(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void deletePublicacion(Long id);
    void updatePublicacion(Long id, Publicacion publicacionActualizada);
}
