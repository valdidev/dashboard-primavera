package com.cursolucasmoy.cursosb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id @Column(name = "id")
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
