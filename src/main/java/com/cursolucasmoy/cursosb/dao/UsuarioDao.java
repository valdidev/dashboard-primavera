package com.cursolucasmoy.cursosb.dao;

import com.cursolucasmoy.cursosb.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);
}
