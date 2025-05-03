package com.cursolucasmoy.cursosb.dao;

import com.cursolucasmoy.cursosb.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void registrar(Usuario usuario);

    Usuario usuarioPorCredenciales(Usuario usuario);

    void eliminar(Long id);

    default void nuevaFnInterfaces() {
        System.out.println("hola");
    }
}
