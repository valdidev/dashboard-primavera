package com.cursolucasmoy.cursosb.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name = "proyectos")
@Data
public class Proyecto {

    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "lenguaje")
    private String lenguaje;
}
