package com.motom.aquila.daos.contracts;


import com.motom.aquila.models.Entidade;

import java.util.List;
import java.util.Map;

public interface Dao<T extends Entidade> {

    void criar(T entidade);
    void editar(T entidade);
    List<T> buscarTodos();
    List<T> buscarTodos(String orderBy);
    List<T> buscarTodos(Map<String, Object> where);
    List<T> buscarTodos(Map<String, Object> where, String orderBy);
    T buscarPorId(Long id);
    void deletar(Long id);

}
