package Ressources;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pid.service.CatalogueService;;


@Path("/Catalogues")
@RequestScoped
public class CatalogueRessource {
	EntityManager em;
	
	CatalogueService CataloguesServices;

	@GET
    @Produces(MediaType.APPLICATION_JSON)

	public Response getCatalogues() {
		return Response.ok(CataloguesServices.findAllCatalogues()).build() ; 
	}
/*
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFormation(Formation formation) {
		if (formation != null) {
			formations.add(formation);
			return Response.status(Response.Status.CREATED).entity("Formation ajouté ").build();
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("Formation non ajouté").build();
	}
	*/
}
