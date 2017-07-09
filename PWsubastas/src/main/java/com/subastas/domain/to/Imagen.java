package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Imagen")
public class Imagen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "imagen_id")
	private BigDecimal imagenId;
	@Column(name = "imagen_url")
	private String imagenUrl;
	@Column(name = "imagen_descripcion")
	private String imagenDescripcion;
	@Column(name = "imagen_fechaagregacion")
	private Date imagenFechaAgregacion;
	@Column(name = "imagen_producto")
	private BigDecimal imagenProducto;
	
	@Column(name = "imagen")
	private byte[] imagen;
	
	public Imagen() {
		super();
	}


	public Imagen(BigDecimal imagenId, String imagenUrl, String imagenDescripcion,
			Date imagenFechaAgregacion, BigDecimal imagenProducto) {
		super();
		this.imagenId = imagenId;
		this.imagenUrl = imagenUrl;
		this.imagenDescripcion = imagenDescripcion;
		this.imagenFechaAgregacion = imagenFechaAgregacion;
		this.imagenProducto = imagenProducto;
	}


	public BigDecimal getImagenId() {
		return imagenId;
	}


	public void setImagenId(BigDecimal imagenId) {
		this.imagenId = imagenId;
	}


	public String getImagenUrl() {
		return imagenUrl;
	}


	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}


	public String getImagenDescripcion() {
		return imagenDescripcion;
	}


	public void setImagenDescripcion(String imagenDescripcion) {
		this.imagenDescripcion = imagenDescripcion;
	}


	public Date getImagenFechaAgregacion() {
		return imagenFechaAgregacion;
	}


	public void setImagenFechaAgregacion(Date imagenFechaAgregacion) {
		this.imagenFechaAgregacion = imagenFechaAgregacion;
	}


	public BigDecimal getImagenProducto() {
		return imagenProducto;
	}


	public void setImagenProducto(BigDecimal imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public byte[] getImagen() {
		return imagen;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	

}
