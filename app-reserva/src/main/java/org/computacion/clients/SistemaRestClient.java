package org.computacion.clients;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.computacion.dto.UsuarioDto;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/usuario")
public interface SistemaRestClient {

    @GET
    @Path("/sala/{nombre}")
    UsuarioDto buscarPorId(@PathParam("nombre")String nombre);

}
