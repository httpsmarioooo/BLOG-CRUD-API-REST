package com.example.prueba.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Publicacion;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    // Relación con Usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Persona", nullable = false)
    private Persona persona;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comentario> comentarios= new ArrayList<>();
    
    public Publicacion() {
        this.fechaCreacion = LocalDateTime.now(); // Asignar fecha al momento de creación
    }

    public Publicacion(Long id_Publicacion, String titulo, String contenido, LocalDateTime fechaCreacion, Persona persona, List<Comentario> comentarios) {
        this.id_Publicacion = id_Publicacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.persona = persona;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public Long getId_Publicacion() {
        return id_Publicacion;
    }

    public void setId_Publicacion(Long id_Publicacion) {
        this.id_Publicacion = id_Publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
