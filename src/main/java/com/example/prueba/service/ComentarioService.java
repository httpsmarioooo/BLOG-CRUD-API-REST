package com.example.prueba.service;

import com.example.prueba.domain.Comentario;
import com.example.prueba.domain.Persona;
import com.example.prueba.repository.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IComentarioService{

    private final IComentarioRepository comentarioRepository;
    @Autowired
    public ComentarioService(IComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }
    @Override
    public List<Comentario> obtenerTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario obtenerPorId(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public void crearComentario(Comentario comentario) {
        comentarioRepository.save(comentario);

    }

    @Override
    public void deleteComentario(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("El comentario con ID " + id + " no existe");
        }
        comentarioRepository.deleteById(id);
    }

    @Override
    public void updateComentario(Long id, Comentario comentarioActualizado) {
        Optional<Comentario> comentarioExistente = comentarioRepository.findById(id);
        if (comentarioExistente.isPresent()) {
            Comentario comentario = comentarioExistente.get();
            comentario.setTexto(comentarioActualizado.getTexto());
            comentarioRepository.save(comentario);
        } else {
            throw new RuntimeException("El comentario con ID " + id + " no existe");
        }
    }
}
