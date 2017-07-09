package com.subastas.client;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import javax.ws.rs.core.MediaType;
import com.subastas.domain.dao.ConsultasDAO;
import com.subastas.domain.dao.ConsultasDAOImpl;
import com.subastas.domain.to.Consulta;

@Path("/consultas")
public class ConsultasClient {
	private List<Consulta> consultas = null;
	private ConsultasDAO dao = new ConsultasDAOImpl();

	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllConsultas() throws JSONException {
		consultas = dao.findAll(Consulta.class);
		String result = consultas.toString();
		return Response.status(200).entity(result).build();
	}

	
	
	
	
	@PermitAll
	@Path("id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findConsultasById(@PathParam("id") Integer id)
			throws JSONException {
		String result = dao.findById(Consulta.class, new BigDecimal(id))
				.toString();
		return Response.status(200).entity(result).build();
	}

	@RolesAllowed("ADMIN")
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addConsulta(Consulta consulta) {
		Consulta result = dao.create(consulta);
		return Response.status(200).entity(result.toString()).build();
	}
}