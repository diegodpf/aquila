package com.motom.aquila.services.contracts;


import com.motom.aquila.models.Vigilante;

import java.util.List;

public interface VigilanteService {

    void criar(Vigilante vigilante);
    void editar(Vigilante vigilante);
    List<Vigilante> buscarTodos();
    Vigilante buscarPorId(Long id);

}
