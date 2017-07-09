package com.subastas.domain.dao;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.subastas.domain.dao.ConsultasDAO;
import com.subastas.domain.dao.ConsultasDAOImpl;
import com.subastas.domain.to.Consulta;

public class ConsultasDAOTest {
	
ConsultasDAO dao = new ConsultasDAOImpl();
Consulta consulta =  new Consulta();
Consulta result = null;
	@Before
	public void setUp() throws Exception {
		consulta.setComentario("basic comment");
		consulta.setEmail("mail@mail.com");
		consulta.setNombre("Eli1123");
		consulta.setTelefono("95992434");
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	@Rollback(true)
	public void testCreatedEntity() {
		if(result == null)
		  result = dao.create(consulta);
		assertEquals(result.getEmail(),consulta.getEmail());
		assertEquals(result.getNombre(),consulta.getNombre());
		assertEquals(result.getTelefono(),consulta.getTelefono());
		assertEquals(result.getComentario(),consulta.getComentario());
		
	}
	
	@Test
	public void testFindEntity(){
		if(result == null)
			  result = dao.create(consulta);
		Consulta resultFound = dao.findById(Consulta.class, result.getConsultaId());
		assertNotNull(resultFound);
		assertEquals(result.getComentario(),resultFound.getComentario());
	}

}
