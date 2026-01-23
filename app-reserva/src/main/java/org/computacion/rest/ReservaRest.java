package org.computacion.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.computacion.db.Reserva;
import org.computacion.service.ReservaService;


@Path("/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaRest {

    @Inject
    ReservaService reservaService;

    @POST
    public Response crearReserva(Reserva reserva) {
        try {
            reservaService.crearReserva(reserva);
            return Response.status(Response.Status.CREATED).entity(reserva).build();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    public Response obtenerReservas() {
        return Response.ok(reservaService.obtenerReservas()).build();
    }


}
