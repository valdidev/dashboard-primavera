package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @GetMapping("/usuario")
    public Usuario recibirUsuario()
    {
        Usuario usuario = new Usuario();
        usuario.setNombre("fernando");
        usuario.setApellidos("valdi");
        usuario.setEmail("fernando@fake-email.com");
        usuario.setTelefono("7848744");
        usuario.setPassword("123");
        return usuario;
    }
}
