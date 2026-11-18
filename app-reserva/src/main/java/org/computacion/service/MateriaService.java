package org.computacion.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.computacion.db.Materia;
import org.computacion.repo.MateriaRepository;

import java.util.List;

@ApplicationScoped
@Transactional
public class MateriaService {

    @Inject
    MateriaRepository materiaRepository;

    public List<Materia> buscarMaterias() {
        return materiaRepository.listAll();
    }

    public Materia buscarMateriaPorId(Integer idMateria) {
        return materiaRepository.findById(idMateria);
    }

    public List<Materia> buscarMateriasPorCarrera(String carrera) {
        return materiaRepository.buscarPorCarrera(carrera);
    }

    public Materia guardar(Materia materia) {
        materiaRepository.persist(materia);
        return materia;
    }

}
