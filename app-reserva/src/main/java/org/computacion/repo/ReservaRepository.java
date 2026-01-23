package org.computacion.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.computacion.db.Reserva;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Transactional
public class ReservaRepository implements PanacheRepositoryBase<Reserva, Integer> {

    public List<Reserva> buscarReservas() {
        return this.listAll();
    }

    public void guardarReserva(Reserva reserva) {
        this.persist(reserva);
    }

    public boolean existeReservaSolapada(Integer idSala, LocalDateTime inicio, LocalDateTime fin) {
        return count(
                "sala.id = ?1 AND estado = 'ACTIVA' " + "AND fechaHoraInicio < ?3 AND fechaHoraFin > ?2",
                idSala,
                inicio,
                fin) > 0;
    }
}


