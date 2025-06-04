package com.example.prueba.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Persona;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cargo;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe ser válido")
    @Column(nullable = false)
    private String email;

//    @OneToMany(mappedBy = "Persona", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Publicacion> publicaciones= new ArrayList<>();


    public Persona() {}

    public Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    public Persona(Long id_Persona, String nombre, String cargo, String email) {
        this.id_Persona = id_Persona;
        this.nombre = nombre;
        this.cargo = cargo;
        this.email = email;
    }

    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}