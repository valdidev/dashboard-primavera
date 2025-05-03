package com.cursolucasmoy.cursosb.services;

import com.cursolucasmoy.cursosb.dao.UsuarioDao;
import com.cursolucasmoy.cursosb.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> listado() {
        return usuarioDao.getUsuarios();
    }

    public void eliminar(Long id) {
        usuarioDao.eliminar(id);
    }
}
