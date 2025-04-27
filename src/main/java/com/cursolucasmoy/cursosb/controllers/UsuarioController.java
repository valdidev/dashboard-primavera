package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
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

    @RequestMapping("usuarios")
    public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("kike");
        usuario.setApellidos("ramos");
        usuario.setEmail("kramos@fake-email.com");
        usuario.setTelefono("1783374");
        usuario.setPassword("123");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("pablo");
        usuario2.setApellidos("sanz");
        usuario2.setEmail("psanz@fake-email.com");
        usuario2.setTelefono("09893894");
        usuario2.setPassword("123");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setNombre("fernando");
        usuario3.setApellidos("valdi");
        usuario3.setEmail("fernando@fake-email.com");
        usuario3.setTelefono("7848744");
        usuario3.setPassword("123");

        //usuarios.add(usuario);
        //usuarios.add(usuario2);
        //usuarios.add(usuario3);

        usuarios.addAll(Arrays.asList(usuario, usuario2, usuario3));

        return usuarios;
    }
}
