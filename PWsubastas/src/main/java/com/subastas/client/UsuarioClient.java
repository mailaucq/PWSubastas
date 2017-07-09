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
import com.subastas.domain.dao.UsuariosDAO;
import com.subastas.domain.dao.UsuariosDAOImpl;
import com.subastas.domain.to.Usuario;
import com.subastas.service.UsuarioService;
import com.subastas.service.UsuarioServiceImpl;

@Path("/usuarios")
public class UsuarioClient {
	private List<Usuario> Usuarios = null;
	private UsuarioService service = new UsuarioServiceImpl();
	private UsuariosDAO dao = new UsuariosDAOImpl();

	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllUsuarios() throws JSONException {
		Usuarios = dao.findAll(Usuario.class);
		String result = Usuarios.toString();
		return Response.status(200).entity(result).build();
	}

	@PermitAll
	@Path("id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUsersById(@PathParam("id") Integer id)
			throws JSONException {
		String result = dao.findById(Usuario.class, new BigDecimal(id))
				.toString();
		return Response.status(200).entity(result).build();
	}

	@PermitAll
	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Usuario usuario)
			throws JSONException {
		String result = "";
		Usuario usuario1 = dao.findByNamedQuery("Usuario.findByUsuarioNombre",
				usuario.getUsuarioNombre()).get(0);
		if (usuario != null
				&& usuario1.getUsuarioPassword().equals(usuario.getUsuarioPassword()))
			result = usuario.toString();
		return Response.status(200).entity(result).build();
	}

	
	@RolesAllowed("ADMIN")
	@Path("name/{nombre}/password/{clave}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUsersByUserAndPass(
			@PathParam("nombre") String nombreUsuario,
			@PathParam("clave") String claveUsuario) throws JSONException {
		String result = "";
		Usuario usuario = dao.findByNamedQuery("Usuario.findByUsuarioNombre",
				nombreUsuario).get(0);
		if (usuario != null
				&& usuario.getUsuarioPassword().equals(claveUsuario))
			result = usuario.toString();
		return Response.status(200).entity(result).build();
	}

	@RolesAllowed("ADMIN")
	@Path("name/{nombre}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUsersByName(@PathParam("nombre") String nombreUsuario)
			throws JSONException {
		String result = result = dao
				.findByNamedQuery("Usuario.findByUsuarioNombre", nombreUsuario)
				.get(0).toString();
		return Response.status(200).entity(result).build();
	}

//	@RolesAllowed("ADMIN")
	@PermitAll
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuario(Usuario Usuario) {
		Usuario result = dao.create(Usuario);
		return Response.status(200).entity(result.toString()).build();
	}
}