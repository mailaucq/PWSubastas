package com.subastas.service;

import java.math.BigDecimal;
import java.util.List;

import com.subastas.domain.to.Tags;
import com.subastas.domain.to.UserItemTag;




public interface UserItemTagService {
	public UserItemTag addUserItemTagCurrentUsuario(Tags tags);

	public List<Tags> findTagsByCurrentUsuario();

	public List<Tags> findTagsByProductoId(BigDecimal productoId);

	public List<Object[]> findTagsCountByUsuario(BigDecimal usuarioId);

	public List<Tags> findAll();

	public List<Object[]> findTagsCountByItem(BigDecimal productoId);
}