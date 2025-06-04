package com.example.prueba.repository;

import com.example.prueba.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository  extends JpaRepository<Comentario, Long> {
}
