package org.computacion.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.computacion.db.Reserva;
import org.computacion.service.ReservaService;

import java.util.List;


@Path("/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaRest {

    @Inject
    ReservaService reservaService;

    @GET
    public List<Reserva> obtenerReservas() {
        return reservaService.listarReservas();
    }

    @GET
    @Path("/{id}")
    public Reserva obtenerReservaPorId(@PathParam("id") Integer id) {
        return reservaService.buscarReserva(id);
    }

    @POST
    public Reserva crearReserva(Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    @PUT
    @Path("/{id}/cancelar")
    public Reserva cancelarReserva(@PathParam("id") Integer id) {

        return reservaService.cancelarReserva(id);
    }


}
