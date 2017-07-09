package com.subastas.domain.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.subastas.domain.to.Moneda;
import com.subastas.domain.to.Tags;

public class TagDAOTest {
	TagsDAO dao = new TagsDAOImpl();
	Tags tags = new Tags();
	Tags result = null;

	@Before
	public void setUp() throws Exception {
		tags.setTagText("apple");
		tags.setStemmedText("appl");
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(result);
	}

	@Test
	public void testCreatedEntity() {
		if(result == null)
			result = dao.create(tags);
		assertEquals(result.getTagText(), tags.getTagText());
		assertEquals(result.getStemmedText(), tags.getStemmedText());
	}
	
	@Test
	public void testFindEntity() {
		if(result == null)
			result = dao.create(tags);
		Tags resultFound = dao.findById(Tags.class, result.getTagId());
		assertEquals(result.getTagText(), tags.getTagText());
		assertEquals(result.getStemmedText(), tags.getStemmedText());
	}

}
