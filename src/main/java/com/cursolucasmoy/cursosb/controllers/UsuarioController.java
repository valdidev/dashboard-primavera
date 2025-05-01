package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.dao.UsuarioDao;
import com.cursolucasmoy.cursosb.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @PostMapping("usuario")
    public void registro(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String passwordHashed = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(passwordHashed);

        usuarioDao.registrar(usuario);
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
