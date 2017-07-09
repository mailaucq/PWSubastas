package com.subastas.domain.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.subastas.domain.dao.MonedaDAO;
import com.subastas.domain.dao.MonedaDAOImpl;
import com.subastas.domain.to.Imagen;
import com.subastas.domain.to.Moneda;

public class MonedaDAOTest {
MonedaDAO dao = new MonedaDAOImpl();
Moneda moneda = new Moneda();
Moneda result = null;

	@Before
	public void setUp() throws Exception {
		moneda.setMonedaNombre("monedaN");
		moneda.setMonedaValorReal(new BigDecimal(100));
		moneda.setMonedaValorVirtual(new BigDecimal(50));
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	public void testCreatedEntity() {
		if(result == null)
			result = dao.create(moneda);
		assertEquals(result.getMonedaNombre(), moneda.getMonedaNombre());
		assertEquals(result.getMonedaValorReal(), moneda.getMonedaValorReal());
		assertEquals(result.getMonedaValorVirtual(), moneda.getMonedaValorVirtual());
	}
	
	@Test
	public void testFindEntity() {
		if(result == null)
			result = dao.create(moneda);
		Moneda resultFound = dao.findById(Moneda.class, result.getMonedaId());
		assertEquals(result.getMonedaNombre(), resultFound.getMonedaNombre());
		assertEquals(result.getMonedaValorReal(), resultFound.getMonedaValorReal());
		assertEquals(result.getMonedaValorVirtual(), resultFound.getMonedaValorVirtual());
	}

}
