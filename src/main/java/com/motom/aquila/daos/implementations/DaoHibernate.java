package com.motom.aquila.daos.implementations;

import com.motom.aquila.daos.contracts.Dao;
import com.motom.aquila.models.Entidade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

abstract class DaoHibernate<T extends Entidade> implements Dao<T> {

    private Class<T> persistedClass;

    DaoHibernate(Class<T> persistedClass) {
        this.persistedClass = persistedClass;
    }

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void criar(T entidade) {
        manager.persist(entidade);
    }

    @Override
    public List<T> buscarTodos() {
        return buscarTodos(null, null);
    }

    @Override
    public List<T> buscarTodos(String orderBy) {
        return buscarTodos(null, orderBy);
    }

    @Override
    public List<T> buscarTodos(Map<String, Object> where) {
        return buscarTodos(where, null);
    }

    @Override
    public List<T> buscarTodos(Map<String, Object> where, String orderBy) {
        int aux;
        String query = "select e from " + persistedClass.getName() + " e";
        if(where != null) {
            aux = 1;
            query += " where 1=1";
            for(Map.Entry<String, Object> item : where.entrySet()) {
                query += " and e." + item.getKey() + " = ?" + aux;
                aux += 1;
            }
        }
        if(orderBy != null) query += " order by e." + orderBy;
        TypedQuery<T> typedQuery  = manager.createQuery(query, persistedClass);
        if(where != null) {
            aux = 1;
            for(Map.Entry<String, Object> item : where.entrySet()) {
                typedQuery.setParameter(aux, item.getValue());
                aux += 1;
            }
        }
        return typedQuery.getResultList();
    }

    @Override
    public T buscarPorId(Long id) {
        return manager.find(persistedClass, id);
    }

    @Override
    public void editar(T entidade) {
        manager.merge(entidade);
    }

    @Override
    public void deletar(Long id) {
        manager.createQuery("delete from " + persistedClass.getName() + " e where e.id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
