package com.example.prueba.service;

import com.example.prueba.domain.Publicacion;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPublicacionService {
    List<Publicacion> obtenerTodos();
    Publicacion obtenerPorId(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void deletePublicacion(Long id);
    void updatePublicacion(Long id, Publicacion publicacionActualizada);
//    void asignarComentarioAPublicacion(Long idpublicacion, Long idComentario);
}
