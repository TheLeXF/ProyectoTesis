package org.computacion.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.computacion.db.Materia;
import org.computacion.service.MateriaService;

import java.util.List;

@Path("/materias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MateriaRest {

    @Inject
    MateriaService materiaService;

    @GET
    public List<Materia> obtenerMaterias() {
        return materiaService.buscarMaterias();
    }

    @GET
    @Path("/{id}")
    public Materia obtenerMateriaPorId(Integer id) {
        return  materiaService.buscarMateriaPorId(id);
    }

    @POST
    public Materia crearMateria(Materia materia) {
        return materiaService.guardar(materia);
    }


}
