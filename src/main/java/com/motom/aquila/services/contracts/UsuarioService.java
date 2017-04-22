package com.motom.aquila.services.contracts;


import com.motom.aquila.models.Usuario;

import java.util.List;

public interface UsuarioService {

    void criar(Usuario usuario);
    List<Usuario> buscarTodos();
    Usuario buscarPorId(Long id);

}
