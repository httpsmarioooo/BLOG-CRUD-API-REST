package com.example.prueba.service;

import com.example.prueba.domain.Comentario;
import com.example.prueba.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IComentarioService {
    List<Comentario> obtenerTodos();
    Comentario obtenerPorId (Long id);
    void crearComentario(Comentario comentario);
    void deleteComentario(Long id);                      // 👈 Eliminar comentario por ID
    void updateComentario(Long id, Comentario comentarioActualizado);
}
