package com.subastas.service;

import java.math.BigDecimal;
import java.util.List;

import com.subastas.domain.to.Usuario;


public interface UsuarioService {

	public void add(Usuario user);
	public void updateUsuarioXSaldo(BigDecimal usuarioId, BigDecimal saldo);
	public Usuario validarUsuario(String nombreUsuario, String claveUsuario);
	public Usuario findUsuarioByName(String nombreUsuario);
	public String getCurrentUsuarioNombre();
	public List<Usuario> findAll();
}