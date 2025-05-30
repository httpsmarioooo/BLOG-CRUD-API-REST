package com.example.prueba.service;

import com.example.prueba.domain.Publicacion;
import com.example.prueba.repository.IPublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService implements IPublicacionService {

    private final IPublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionService(IPublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    @Override
    public List<Publicacion> obtenerTodos() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion obtenerPorId(Long id) {
        return publicacionRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarPublicacion(Publicacion publicacion) {
        publicacionRepository.save(publicacion);
    }

    @Override
    public void deletePublicacion(Long id) {
        if (!publicacionRepository.existsById(id)) {
            throw new RuntimeException("La publicación con ID " + id + " no existe");
        }
        publicacionRepository.deleteById(id);
    }

    @Override
    public void updatePublicacion(Long id, Publicacion publicacionActualizada) {
        Publicacion existente = publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La publicación con ID " + id + " no existe"));

        existente.setTitulo(publicacionActualizada.getTitulo());
        existente.setContenido(publicacionActualizada.getContenido());
        existente.setPersona(publicacionActualizada.getPersona());

        publicacionRepository.save(existente);
    }
}
