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
import com.subastas.domain.dao.ProductoDAO;
import com.subastas.domain.dao.ProductoDAOImpl;
import com.subastas.domain.to.Producto;

@Path("/productos")
public class ProductosClient {
	private List<Producto> productos = null;
	private ProductoDAO  dao = new ProductoDAOImpl();
	
	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProductos() throws JSONException {
		productos = dao.findAll(Producto.class);
		String result = productos.toString();
		return Response.status(200).entity(result).build();
	}

	@PermitAll
	@Path("word/{word}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findProductsByName(@PathParam("word") String word)
			throws JSONException {
		productos = dao.getProductos(word);
		String result = productos.toString();
		return Response.status(200).entity(result).build();
	}
	
	@PermitAll
	@Path("id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findProductsById(@PathParam("id") Integer id)
			throws JSONException {
		String result = dao.findById(Producto.class, new BigDecimal(id)).toString();
		return Response.status(200).entity(result).build();
	}
	
	@RolesAllowed("ADMIN")
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProducto(Producto producto){
		Producto result = dao.create(producto);
		return Response.status(200).entity(result.toString()).build();
	}
}