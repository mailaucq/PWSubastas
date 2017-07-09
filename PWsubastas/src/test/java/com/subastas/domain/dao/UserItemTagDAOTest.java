package com.subastas.domain.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.subastas.domain.to.UserItemTag;
import com.subastas.domain.to.UserItemTagKey;

public class UserItemTagDAOTest {
	UserItemTagDAO dao = new UserItemTagDAOImpl();
	UserItemTag userItemTag = new UserItemTag();
	UserItemTag result = null;

	@Before
	public void setUp() throws Exception {
		userItemTag.setUsuarioId(new BigDecimal(3));
		userItemTag.setTagId(new BigDecimal(1));
		userItemTag.setItemId(new BigDecimal(35));
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	public void testCreatedEntity() {
		if(result == null)
			result = dao.create(userItemTag);
		assertEquals(result.getItemId(), userItemTag.getItemId());
		assertEquals(result.getTagId(), userItemTag.getTagId());
		assertEquals(result.getUsuarioId(), userItemTag.getUsuarioId());
	}
	
	@Test
	public void testFindEntity() {
		if(result == null)
			result = dao.create(userItemTag);
		UserItemTag resultFound = dao.findById(UserItemTag.class, new UserItemTagKey(result.getItemId(),result.getTagId(), result.getUsuarioId()));
		assertEquals(result.getItemId(), userItemTag.getItemId());
		assertEquals(result.getTagId(), userItemTag.getTagId());
		assertEquals(result.getUsuarioId(), userItemTag.getUsuarioId());
	}

}
