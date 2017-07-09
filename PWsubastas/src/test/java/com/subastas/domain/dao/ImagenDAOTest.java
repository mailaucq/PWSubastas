package com.subastas.domain.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.subastas.domain.dao.ImagenDAO;
import com.subastas.domain.dao.ImagenDAOImpl;
import com.subastas.domain.to.Imagen;

public class ImagenDAOTest {
ImagenDAO dao = new ImagenDAOImpl();
Imagen imagen = new Imagen();
Imagen result = null;

	@Before
	public void setUp() throws Exception {
		imagen.setImagenDescripcion("descripcion 1");
		imagen.setImagenFechaAgregacion(new Date());
		imagen.setImagenUrl("image.jpg");
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	public void testCreatedEntity() {
		if(result == null)
			result = dao.create(imagen);
		assertEquals(result.getImagenDescripcion(), imagen.getImagenDescripcion());
		assertEquals(result.getImagenFechaAgregacion(), imagen.getImagenFechaAgregacion());
		assertEquals(result.getImagenUrl(), imagen.getImagenUrl());
	}
	
	@Test
	public void testFindEntity() {
		if(result == null)
			result = dao.create(imagen);
		Imagen resultFound = dao.findById(Imagen.class, result.getImagenId());
		assertEquals(result.getImagenDescripcion(), resultFound.getImagenDescripcion());
		assertEquals(result.getImagenFechaAgregacion(), resultFound.getImagenFechaAgregacion());
		assertEquals(result.getImagenUrl(), resultFound.getImagenUrl());
		
	}
}
