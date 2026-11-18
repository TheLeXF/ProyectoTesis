package org.computacion.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.computacion.db.Profesor;
import org.computacion.service.ProfesorService;

import java.util.List;

@Path("/profesores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfesorRest {

    @Inject
    ProfesorService profesorService;

    @GET
    public List<Profesor> buscarProfesores() {
        return profesorService.listarProfesores();
    }

    @GET
    @Path("/{id}")
    public Profesor buscarProfesorPorId(@PathParam("id") Integer id) {
        return profesorService.buscarProfesorPorId(id);
    }

}
