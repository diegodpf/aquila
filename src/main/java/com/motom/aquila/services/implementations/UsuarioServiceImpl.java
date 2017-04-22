package com.motom.aquila.services.implementations;


import com.motom.aquila.daos.contracts.UsuarioDao;
import com.motom.aquila.models.Usuario;
import com.motom.aquila.services.contracts.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao dao;

    @Override
    public void criar(Usuario usuario) {
        dao.criar(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }
}
