package com.motom.aquila.daos.implementations;

import com.motom.aquila.daos.contracts.UsuarioDao;
import com.motom.aquila.models.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoHibernate extends DaoHibernate<Usuario> implements UsuarioDao {
    UsuarioDaoHibernate() {
        super(Usuario.class);
    }
}
