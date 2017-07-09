package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import com.subastas.domain.to.Tags;

public interface TagsDAO extends GenericDAO<Tags,BigDecimal>  {

	List<Object[]> findTagsByUsuarioCount(BigDecimal usuarioId);

	List<Object[]> findTagsCountByItem(BigDecimal productoId);
}
