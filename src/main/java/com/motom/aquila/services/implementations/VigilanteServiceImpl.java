package com.motom.aquila.services.implementations;


import com.motom.aquila.daos.contracts.VigilanteDao;
import com.motom.aquila.models.Vigilante;
import com.motom.aquila.services.contracts.VigilanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class VigilanteServiceImpl implements VigilanteService {

    @Autowired
    private VigilanteDao dao;

    @Override
    public void criar(Vigilante vigilante) {
        dao.criar(vigilante);
    }

    @Override
    public void editar(Vigilante vigilante) {
        dao.editar(vigilante);
    }

    @Override
    public List<Vigilante> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public Vigilante buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }
}
