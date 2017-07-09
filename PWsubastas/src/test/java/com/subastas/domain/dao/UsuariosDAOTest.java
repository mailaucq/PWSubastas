package com.subastas.domain.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.subastas.domain.dao.UsuariosDAO;
import com.subastas.domain.dao.UsuariosDAOImpl;
import com.subastas.domain.to.Usuario;

public class UsuariosDAOTest {
	UsuariosDAO dao = new UsuariosDAOImpl();
	Usuario usuario = new Usuario();
	Usuario result = null;
	@Before
	public void setUp() throws Exception {
		usuario.setUsuarioEmail("email@emai");
		usuario.setUsuarioNombre("name1");
		usuario.setUsuarioPassword("password1");
		usuario.setUsuarioSaldo(new BigDecimal(1000));
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	public void testCreatedEntity() {
		if(result == null)
			result = dao.create(usuario);
		assertEquals(result.getUsuarioNombre(), usuario.getUsuarioNombre());
		assertEquals(result.getUsuarioPassword(), usuario.getUsuarioPassword());
		assertEquals(result.getUsuarioEmail(), usuario.getUsuarioEmail());
	}

	@Test
	public void testFindEntity() {
		if(result == null)
			result = dao.create(usuario);
		Usuario resultFound = dao.findById(Usuario.class, result.getUsuarioId());
		assertEquals(result.getUsuarioNombre(), resultFound.getUsuarioNombre());
		assertEquals(result.getUsuarioPassword(), resultFound.getUsuarioPassword());
		assertEquals(result.getUsuarioEmail(), resultFound.getUsuarioEmail());
	}

}
