package com.subastas.domain.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.subastas.domain.dao.ProductoDAO;
import com.subastas.domain.dao.ProductoDAOImpl;
import com.subastas.domain.to.Producto;

public class ProductoDAOTest {
ProductoDAO dao  = new ProductoDAOImpl();
Producto producto = new Producto();
Producto result = null;

	@Before
	public void setUp() throws Exception {
		producto.setProductoDescripcion("descripcion 1");
		producto.setProductoNombre("prod1");
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	public void testCreatedEntity() {
		if(result == null)
			result = dao.create(producto);
		assertEquals(producto.getProductoDescripcion(), result.getProductoDescripcion());
		assertEquals(producto.getProductoNombre(), result.getProductoNombre());
//		assertNotEquals(producto.getProductoDescripcion(), result.getProductoNombre());
	}
	
	@Test
	public void testFindEntity() {
		if(result == null)
			result = dao.create(producto);
		Producto resultFound = dao.findById(Producto.class,result.getProductoId() );
		assertEquals(producto.getProductoDescripcion(), resultFound.getProductoDescripcion());
		assertEquals(producto.getProductoNombre(), resultFound.getProductoNombre());
//		assertNotEquals(producto.getProductoDescripcion(), resultFound.getProductoNombre());
	}

}
