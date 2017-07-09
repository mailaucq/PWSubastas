package com.subastas.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.TagsDAO;
import com.subastas.domain.dao.UserItemTagDAO;
import com.subastas.domain.to.Tags;
import com.subastas.domain.to.UserItemTag;
import com.subastas.domain.to.Usuario;

@Service
public class UserItemTagServiceImpl implements UserItemTagService {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	UserItemTagDAO userItemTagDAO;
	@Autowired
	TagsDAO tagsDAO;
	String contextURL = "http://localhost:8080/PWsubastas/secured";
	
	@Override
	public UserItemTag addUserItemTagCurrentUsuario(Tags tags) {
		UserItemTag result = null;
		List<Tags> resultTagsList = tagsDAO.findByNamedQuery("Tags.findBytagText", tags.getTagText());
		Tags resultTags = null;
		if (resultTagsList != null && resultTagsList.size() > 0) {
			resultTags = resultTagsList.get(0);
		} else {
			resultTags = tagsDAO.create(tags);
		}
		String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
		Usuario usuario = usuarioService.findUsuarioByName(usuarioNombre);
		UserItemTag userItemTag = new UserItemTag();
		userItemTag.setUsuarioId(usuario.getUsuarioId());
		userItemTag.setTagId(resultTags.getTagId());
		userItemTag.setItemId(tags.getProductoId());
		userItemTag.setCreateDate(new Date());
		result = userItemTagDAO.create(userItemTag);
		return result;
	}

	@Override
	public List<Tags> findTagsByCurrentUsuario() {
		String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
		Usuario usuario = usuarioService.findUsuarioByName(usuarioNombre);
		List<UserItemTag> userItemTags = userItemTagDAO.findByNamedQuery("UserItemTag.findByUsuarioId", usuario.getUsuarioId());
		List<Tags> tagsList = new ArrayList<>();
		for (Iterator iterator = userItemTags.iterator(); iterator.hasNext();) {
			UserItemTag userItemTag = (UserItemTag) iterator.next();
			Tags tags = tagsDAO.findById(Tags.class, userItemTag.getTagId());
			tags.setUrlItem(contextURL+"/productoDescripcion.htm?id="+userItemTag.getItemId());
			tagsList.add(tags);
		}
		return tagsList;
	}

	@Override
	public List<Tags> findTagsByProductoId(BigDecimal productoId) {
		return tagsDAO.findByNamedQuery("Tags.findByProductoId", productoId);
	}

	@Override
	public List<Object[]> findTagsCountByUsuario(BigDecimal usuarioId) {
		return tagsDAO.findTagsByUsuarioCount(usuarioId);
	}

	@Override
	public List<Object[]> findTagsCountByItem(BigDecimal productoId) {
		return tagsDAO.findTagsCountByItem(productoId);
	}
	
	@Override
	public List<Tags> findAll() {
		return tagsDAO.findAll(Tags.class);
	}
}