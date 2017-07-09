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
import com.subastas.domain.dao.MonedaDAO;
import com.subastas.domain.dao.MonedaDAOImpl;
import com.subastas.domain.to.Moneda;

@Path("/monedas")
public class MonedaClient {
	private List<Moneda> Monedas = null;
	private MonedaDAO dao = new MonedaDAOImpl();

	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllMonedas() throws JSONException {
		Monedas = dao.findAll(Moneda.class);
		String result = Monedas.toString();
		return Response.status(200).entity(result).build();
	}

	@PermitAll
	@Path("id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findMonedasById(@PathParam("id") Integer id)
			throws JSONException {
		String result = dao.findById(Moneda.class, new BigDecimal(id))
				.toString();
		return Response.status(200).entity(result).build();
	}

	@RolesAllowed("ADMIN")
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMoneda(Moneda Moneda) {
		Moneda result = dao.create(Moneda);
		return Response.status(200).entity(result.toString()).build();
	}
}