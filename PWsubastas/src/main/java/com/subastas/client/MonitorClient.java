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
import com.subastas.domain.dao.MonitorDAO;
import com.subastas.domain.dao.MonitorDAOImpl;
import com.subastas.domain.to.Monitor;

@Path("/monitors")
public class MonitorClient {
	private List<Monitor> Monitors = null;
	private MonitorDAO dao = new MonitorDAOImpl();

	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllMonitors() throws JSONException {
		Monitors = dao.findAll(Monitor.class);
		String result = Monitors.toString();
		return Response.status(200).entity(result).build();
	}

	@PermitAll
	@Path("id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findMonitorsById(@PathParam("id") Integer id)
			throws JSONException {
		String result = dao.findById(Monitor.class, new BigDecimal(id))
				.toString();
		return Response.status(200).entity(result).build();
	}

	@RolesAllowed("ADMIN")
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMonitor(Monitor Monitor) {
		Monitor result = dao.create(Monitor);
		return Response.status(200).entity(result.toString()).build();
	}
}