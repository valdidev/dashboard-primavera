package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.dao.UsuarioDao;
import com.cursolucasmoy.cursosb.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

   @GetMapping("usuarios")
    public List<Usuario> listaUsuarios()
    {
        return usuarioDao.getUsuarios();
    }

    @DeleteMapping("usuario/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }


    ////////

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
