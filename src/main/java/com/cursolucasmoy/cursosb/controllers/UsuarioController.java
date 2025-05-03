package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.dao.UsuarioDao;
import com.cursolucasmoy.cursosb.models.Usuario;
import com.cursolucasmoy.cursosb.services.UsuarioService;
import com.cursolucasmoy.cursosb.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioSE;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("api/usuarios")
    public ResponseEntity<List<Usuario>> listaUsuarios(@RequestHeader("Authorization") String authHeader) {
        if (!validarToken(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(usuarioSE.listado());
    }

    @DeleteMapping("api/usuario/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id, @RequestHeader("Authorization") String authHeader) {
        if (!validarToken(authHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }
        usuarioSE.eliminar(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

    private boolean validarToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return false;
        }
        String token = authHeader.replace("Bearer ", "");
        return jwtUtil.verifyToken(token);
    }
}