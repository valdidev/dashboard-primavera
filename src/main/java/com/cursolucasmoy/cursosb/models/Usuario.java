package com.cursolucasmoy.cursosb.models;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "usuarios")
@Data
public class Usuario {

    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "password")
    private String password;
}
