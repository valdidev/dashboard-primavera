package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.dao.UsuarioDao;
import com.cursolucasmoy.cursosb.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
