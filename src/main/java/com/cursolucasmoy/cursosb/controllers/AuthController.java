package com.cursolucasmoy.cursosb.controllers;

import com.cursolucasmoy.cursosb.dao.UsuarioDao;
import com.cursolucasmoy.cursosb.models.Usuario;
import com.cursolucasmoy.cursosb.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        try {
            // 1. Verificar credenciales
            Usuario usuarioLogueado = usuarioDao.usuarioPorCredenciales(usuario);
            if (usuarioLogueado == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
            }

            // 2. Verificar que el usuario tenga email e ID válidos
            if (usuarioLogueado.getEmail() == null || usuarioLogueado.getId() == 0L) {
                return ResponseEntity.badRequest().body("Usuario no tiene email o ID válido");
            }

            // 3. Generar token JWT
            String token = jwtUtil.create(
                    String.valueOf(usuarioLogueado.getId()),
                    usuarioLogueado.getEmail()
            );

            // 4. Retornar token
            return ResponseEntity.ok(token);

        } catch (Exception e) {
            e.printStackTrace();  // Debug: Ver error en consola
            return ResponseEntity.status(500).body("Error al generar token: " + e.getMessage());
        }
    }
}

