package org.computacion.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.computacion.db.Reserva;
import org.computacion.repo.ReservaRepository;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ReservaService {

    @Inject
    ReservaRepository reservaRepository;

    private void validarReserva(Reserva reserva) {

        LocalDateTime inicio = reserva.getFechaHoraInicio();
        LocalDateTime fin = reserva.getFechaHoraFin();

        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("El horario de la reserva es obligatorio");
        }

        if (!fin.isAfter(inicio)) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la de inicio");
        }


        if (inicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se permiten reservas en fechas pasadas");
        }

        boolean existeConflicto = reservaRepository.existeReservaSolapada(reserva.getSala().getId(), inicio, fin);

        if (existeConflicto) {
            throw new IllegalStateException("La sala ya se encuentra reservada en ese horario");
        }
    }
    public void crearReserva(Reserva reserva) {
        validarReserva(reserva);
        reserva.setEstado("ACTIVA");
        reservaRepository.guardarReserva(reserva);
    }

    public List <Reserva> obtenerReservas() {
        return reservaRepository.buscarReservas();
    }

}
