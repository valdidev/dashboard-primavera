package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.models.Proyecto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProyectoController {

    private List<Proyecto> lista = new ArrayList<>();

    public ProyectoController() {
        Proyecto p = new Proyecto();
        p.setId(1);
        p.setNombre("proyecto 1");
        p.setLenguaje("Java");

        Proyecto p2 = new Proyecto();
        p2.setId(2);
        p2.setNombre("proyecto 2");
        p2.setLenguaje("Java con Spring");

        lista.add(p);
        lista.add(p2);
    }

    @GetMapping("proyecto/{id}")
    public Proyecto test(@PathVariable Integer id) {
        for (Proyecto proy : lista) {
            if (proy.getId() == id) {
                return proy;
            }
        }

        return null;
    }

    @GetMapping("proyecto/buscar")
    public String buscar(
            @RequestParam(value = "nombre", defaultValue = "") String nombre,
            @RequestParam(value = "edad", defaultValue = "20") String edad) {
        return nombre + " y tiene: " + edad;
    }


    private boolean on;
}
