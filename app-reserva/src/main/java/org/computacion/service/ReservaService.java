package org.computacion.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.computacion.db.Reserva;
import org.computacion.repo.ReservaRepository;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Transactional
public class ReservaService {

    @Inject
    ReservaRepository reservaRepository;

    public List<Reserva> listarReservas(){
        return reservaRepository.listAll();
    }

    public Reserva buscarReserva(Integer id){
        return reservaRepository.findById(id);
    }

    public Reserva crearReserva(Reserva reserva){

        boolean existeCruce = reservaRepository.existeReservaSolapada(
                reserva.getId(),
                reserva.getFechaHoraInicio(),
                reserva.getFechaHoraFin()
        );

        if (existeCruce){
            throw new IllegalStateException("La sala ya está reservada en ese horario.");
        }

        reserva.setEstado(true);

        reservaRepository.persist(reserva);

        return reserva;
    }

    public Reserva cancelarReserva(Integer id){
        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            return null;
        }

        reserva.setEstado(false);

        return reserva;
    }

}
