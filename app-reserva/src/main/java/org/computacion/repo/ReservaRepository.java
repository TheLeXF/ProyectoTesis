package org.computacion.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.computacion.db.Reserva;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Transactional
public class ReservaRepository implements PanacheRepositoryBase<Reserva, Integer> {

    public List<Reserva> buscarReservasActivas() {
        return list("estado", true);
    }

    public List<Reserva> buscarPorSala(Integer idSala) {
        return list("idSala", idSala);
    }

    public boolean existeReservaSolapada( Integer idSala, LocalDateTime inicio, LocalDateTime fin) {

        long cantidad = count( "idSala = ?1 and estado = true and"+
                "(fechaHorarioInicio >?2 and fechaHorarioFin<=?3)", idSala, inicio, fin);

        return cantidad > 0;
    }
}


