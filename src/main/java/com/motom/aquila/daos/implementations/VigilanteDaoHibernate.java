package com.motom.aquila.daos.implementations;

import com.motom.aquila.daos.contracts.VigilanteDao;
import com.motom.aquila.models.Vigilante;
import org.springframework.stereotype.Repository;

@Repository
public class VigilanteDaoHibernate extends DaoHibernate<Vigilante> implements VigilanteDao {
    VigilanteDaoHibernate() {
        super(Vigilante.class);
    }
}
