package com.cursolucasmoy.cursosb.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "apellidos")
    @Getter @Setter
    private String apellidos;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "telefono")
    @Getter @Setter
    private String telefono;

    @Column(name = "password")
    @Getter @Setter
    private String password;
}
