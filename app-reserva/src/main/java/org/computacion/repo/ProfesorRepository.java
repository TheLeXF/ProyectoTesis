package org.computacion.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.computacion.db.Profesor;

@ApplicationScoped
@Transactional
public class ProfesorRepository implements PanacheRepositoryBase<Profesor, Integer> {

    public Profesor buscarPorEmail(String email) {
        return this.find("email", email).firstResult();
    }
}
