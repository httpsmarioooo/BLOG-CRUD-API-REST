package com.example.prueba.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comentario;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    // Relación con Publicacion
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Publicacion", nullable = false)
    @JsonBackReference
    private Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(Long id_comentario, String texto, LocalDateTime fechaCreacion, Publicacion publicacion) {
        this.id_comentario = id_comentario;
        this.texto = texto;
        this.fechaCreacion = fechaCreacion;
        this.publicacion = publicacion;
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
