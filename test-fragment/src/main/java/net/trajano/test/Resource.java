/**
 * 
 */
package net.trajano.test;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author
 */
@Path("resource")
@ManagedBean
public class Resource {

	@EJB
	WebSideSlsb slsb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {

		return Response.ok(Json.createArrayBuilder().add("hello world").build()).build();
	}

	@GET
	@Path("j")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSlsb() {

		return Response.ok(slsb.hello(Json.createObjectBuilder().add("from", "world").build())).build();
	}

	@PostConstruct
	public void init() {
		System.out.println("POSTCONSTRUCT");
		System.out.println(slsb);
	}
}
