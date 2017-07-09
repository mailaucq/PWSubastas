package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity
@Table(name = "Usuario")
@NamedQuery(name="Usuario.findByUsuarioNombre", query="SELECT u FROM Usuario u WHERE u.usuarioNombre = ?1")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO, generator="usuario_id_seq")
	@SequenceGenerator(name="usuario_id_seq", sequenceName="usuario_usuario_id_seq")
	@Column(name = "usuario_id")
	private BigDecimal usuarioId;
	@Column(name = "usuario_nombre")
	private String usuarioNombre;
	@Column(name = "usuario_email")
	private String usuarioEmail;
	@Column(name = "usuario_password")
	private String usuarioPassword;
	@Column(name = "usuario_direccion")
	private String usuarioDireccion;
	@Column(name = "usuario_saldo")
	private BigDecimal usuarioSaldo;
	@Column(name = "usuario_rol")
	private BigDecimal usuarioRol;
	

	public Usuario() {
		super();
	}
	public Usuario(BigDecimal usuarioId, String usuarioNombre, String usuarioPassword,
			String usuarioDireccion, BigDecimal usuarioSaldo) {
		super();
		this.usuarioId = usuarioId;
		this.usuarioNombre = usuarioNombre;
		this.usuarioPassword = usuarioPassword;
		this.usuarioDireccion = usuarioDireccion;
		this.usuarioSaldo = usuarioSaldo;
	}
	
	public Usuario(BigDecimal usuarioId, String usuarioNombre, String usuarioEmail,
			String usuarioPassword, String usuarioDireccion,
			BigDecimal usuarioSaldo, BigDecimal usuarioRol) {
		super();
		this.usuarioId = usuarioId;
		this.usuarioNombre = usuarioNombre;
		this.usuarioEmail = usuarioEmail;
		this.usuarioPassword = usuarioPassword;
		this.usuarioDireccion = usuarioDireccion;
		this.usuarioSaldo = usuarioSaldo;
		this.usuarioRol = usuarioRol;
	}
	public BigDecimal getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(BigDecimal usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuarioNombre() {
		return usuarioNombre;
	}
	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}
	public String getUsuarioEmail() {
		return usuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}
	public String getUsuarioPassword() {
		return usuarioPassword;
	}
	public void setUsuarioPassword(String usuarioPassword) {
		this.usuarioPassword = usuarioPassword;
	}
	public String getUsuarioDireccion() {
		return usuarioDireccion;
	}
	public void setUsuarioDireccion(String usuarioDireccion) {
		this.usuarioDireccion = usuarioDireccion;
	}
	public BigDecimal getUsuarioSaldo() {
		return usuarioSaldo;
	}
	public void setUsuarioSaldo(BigDecimal usuarioSaldo) {
		this.usuarioSaldo = usuarioSaldo;
	}
	public BigDecimal getUsuarioRol() {
		return usuarioRol;
	}
	public void setUsuarioRol(BigDecimal usuarioRol) {
		this.usuarioRol = usuarioRol;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

}
