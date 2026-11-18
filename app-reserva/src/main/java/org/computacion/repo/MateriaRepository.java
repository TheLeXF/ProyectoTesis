package org.computacion.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.computacion.db.Materia;

import java.util.List;

@ApplicationScoped
@Transactional
public class MateriaRepository implements PanacheRepositoryBase<Materia, Integer> {

    public List<Materia> buscarPorCarrera(String carrera) {
        return list("carrera", carrera);
    }
}
