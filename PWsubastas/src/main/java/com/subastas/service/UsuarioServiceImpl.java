package com.subastas.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.UsuariosDAO;
import com.subastas.domain.to.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuariosDAO usuarioDAO;
	public void add(Usuario usuario) {
		usuarioDAO.create(usuario);
	}
	
	public void updateUsuarioXSaldo(BigDecimal usuarioId, BigDecimal saldo){  
	      Usuario usuario = usuarioDAO.findById(Usuario.class, usuarioId);
	      usuario.setUsuarioSaldo(saldo);
	      usuarioDAO.update(usuario);
   }  
	
	public Usuario validarUsuario(String nombreUsuario, String claveUsuario) {
		boolean correcto = false;
		Usuario usuario =  findUsuarioByName(nombreUsuario);
		String nombre = usuario.getUsuarioNombre();
		String password = usuario.getUsuarioPassword();
		correcto = (nombreUsuario.equals(nombre) && claveUsuario.equals(password));
		if (!correcto) {
			usuario = null; 
		}
		return usuario;
	}
	
	public Usuario findUsuarioByName(String nombreUsuario){
		return usuarioDAO.findByNamedQuery("Usuario.findByUsuarioNombre", nombreUsuario).get(0);
	}
	
	public String getCurrentUsuarioNombre() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String usuario = authentication != null ? authentication.getName():"";
		
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDAO.findAll(Usuario.class);
	}
}