package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Producto;
import com.subastas.domain.to.Tags;
@Component("tagsDAO")
public class TagsDAOImpl extends GenericDAOImpl<Tags,BigDecimal> implements TagsDAO {

	@Override
	public List<Object[]> findTagsByUsuarioCount(BigDecimal usuarioId) {
		String query = "SELECT uit3.tagId, t3.tagText, count(*) from UserItemTag uit3, Tags t3 "
			+ "where uit3.tagId = t3.tagId and uit3.usuarioId = "+usuarioId+" group by uit3.tagId, t3.tagText";
		List<Object[]> result = new ArrayList<Object[]>();
		try {
		      entityManager.getTransaction().begin();
		      result = entityManager.createQuery(query).getResultList();
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	    	  entityManager.getTransaction().rollback();
	    }
		return result;
	}

	@Override
	public List<Object[]> findTagsCountByItem(BigDecimal productoId) {
		String query = "Select uit3.tagId, t3.tagText, count(*) from UserItemTag uit3, Tags t3"
				+ " where uit3.tagId = t3.tagId and uit3.itemId = "+productoId+" group by uit3.tagId, t3.tagText";
		List<Object[]> result = new ArrayList<Object[]>();
		try {
		      entityManager.getTransaction().begin();
		      result = entityManager.createQuery(query).getResultList();
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	    	  entityManager.getTransaction().rollback();
	    }
		return result;
	}
}
