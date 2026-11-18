package org.computacion.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.computacion.db.Profesor;
import org.computacion.repo.ProfesorRepository;

import java.util.List;

@Transactional
@ApplicationScoped
public class ProfesorService {
    @Inject
    ProfesorRepository profesorRepository;

    public List<Profesor> listarProfesores() {
        return profesorRepository.listAll();
    }

    public Profesor buscarProfesorPorId(Integer id) {
        return profesorRepository.findById(id);
    }

    public Profesor buscarProfesorPorEmail(String email) {
        return profesorRepository.buscarPorEmail(email);
    }
}
