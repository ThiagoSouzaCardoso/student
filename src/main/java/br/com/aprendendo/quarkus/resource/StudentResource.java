package br.com.aprendendo.quarkus.resource;

import br.com.aprendendo.quarkus.model.Student;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @GET
    @Path("{id}")
    public Response findStudent(@PathParam("id") Long id){
            Student student = Student.findById(id);
            return Response.ok(student).build();
    }

    @POST
    @Transactional
    public Response addStudent(@Valid Student student, @Context UriInfo uriInfo){
        Student.persist(student);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(Integer.parseInt(student.id.toString())));
        return Response.created(builder.build()).build();
    }

}