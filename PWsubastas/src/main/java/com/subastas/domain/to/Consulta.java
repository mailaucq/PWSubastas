package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity
@Table(name = "Consulta")
public class Consulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "consulta_id")
	private BigDecimal consultaId;
	@Column(name = "consulta_usuario_nombre ")
	private String nombre;
	@Column(name = "consulta_usuario_telefono")
	private String telefono;
	@Column(name = "consulta_usuario_email")
	private String email;
	@Column(name = "consulta_comentario")
	private String comentario;

	public Consulta(BigDecimal id, String nombre, String telefono, String email,
			String comentario) {
		this.consultaId = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.comentario = comentario;
	}

	public Consulta() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getConsultaId() {
		return consultaId;
	}

	public void setConsultaId(BigDecimal consultaId) {
		this.consultaId = consultaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String execute() {

		return "SUCCESS";

	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}