package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Entity
@Table(name = "Producto")
public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private BigDecimal productoId;
	@Column(name = "producto_nombre")
	private String productoNombre;
	@Column(name = "producto_estado")
	private String productoEstado;
	@Column(name = "producto_tiempoinicial")
	//@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date productoTiempoInicial;
	@Transient
	private String s_productoTiempoInicial;
	//@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "producto_tiempofinal")
	private Date productoTiempoFinal;
	@Transient
	private String s_productoTiempoFinal;
	@Column(name = "producto_precioreal")
	private double productoPrecioReal;
	@Column(name = "producto_precioVirtual")
	private double productoPrecioVirtual;
	@Column(name = "producto_descripcion")
	private String productoDescripcion;
	@Column(name = "producto_categoria")
	private BigDecimal productoCategoria;
	@Column(name = "producto_vendedor")
	private BigDecimal productoVendedor;
	@Column(name = "producto_ganador")
	private BigDecimal productoGanador;
	@Transient
	private String productoImagen;
	
	public Producto() {
		super();
	}
	
	public Producto(BigDecimal productoId, String productoNombre,
			String productoEstado, Date productoTiempoInicial,
			Date productoTiempoFinal, double productoPrecioReal,
			double productoPrecioVirtual) {
		super();
		this.productoId = productoId;
		this.productoNombre = productoNombre;
		this.productoEstado = productoEstado;
		this.productoTiempoInicial = productoTiempoInicial;
		this.productoTiempoFinal = productoTiempoFinal;
		this.productoPrecioReal = productoPrecioReal;
		this.productoPrecioVirtual = productoPrecioVirtual;
	}


	public Producto(BigDecimal productoId, String productoNombre,
			String productoEstado, Date productoTiempoInicial,
			Date productoTiempoFinal, double productoPrecioReal,
			double productoPrecioVirtual, String productoDescripcion,
			BigDecimal productoCategoria, BigDecimal productoVendedor,
			BigDecimal productoGanador) {
		super();
		this.productoId = productoId;
		this.productoNombre = productoNombre;
		this.productoEstado = productoEstado;
		this.productoTiempoInicial = productoTiempoInicial;
		this.productoTiempoFinal = productoTiempoFinal;
		this.productoPrecioReal = productoPrecioReal;
		this.productoPrecioVirtual = productoPrecioVirtual;
		this.productoDescripcion = productoDescripcion;
		this.productoCategoria = productoCategoria;
		this.productoVendedor = productoVendedor;
		this.productoGanador = productoGanador;
	}
	
	

	public Producto(BigDecimal productoId, String productoNombre,
			String productoEstado, String s_productoTiempoInicial,
			String s_productoTiempoFinal, double productoPrecioReal,
			double productoPrecioVirtual, String productoDescripcion,
			BigDecimal productoCategoria, BigDecimal productoVendedor,
			BigDecimal productoGanador) {
		super();
		this.productoId = productoId;
		this.productoNombre = productoNombre;
		this.productoEstado = productoEstado;
		this.s_productoTiempoInicial = s_productoTiempoInicial;
		this.s_productoTiempoFinal = s_productoTiempoFinal;
		this.productoPrecioReal = productoPrecioReal;
		this.productoPrecioVirtual = productoPrecioVirtual;
		this.productoDescripcion = productoDescripcion;
		this.productoCategoria = productoCategoria;
		this.productoVendedor = productoVendedor;
		this.productoGanador = productoGanador;
	}

	public BigDecimal getProductoId() {
		return productoId;
	}
	public void setProductoId(BigDecimal productoId) {
		this.productoId = productoId;
	}
	public String getProductoNombre() {
		return productoNombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}
	public String getProductoEstado() {
		return productoEstado;
	}
	public void setProductoEstado(String productoEstado) {
		this.productoEstado = productoEstado;
	}
	public Date getProductoTiempoInicial() {
		return productoTiempoInicial;
	}
	public void setProductoTiempoInicial(Date productoTiempoInicial) {
		this.productoTiempoInicial = productoTiempoInicial;
	}
	public Date getProductoTiempoFinal() {
		return productoTiempoFinal;
	}
	public void setProductoTiempoFinal(Date productoTiempoFinal) {
		this.productoTiempoFinal = productoTiempoFinal;
	}
	public double getProductoPrecioReal() {
		return productoPrecioReal;
	}
	public void setProductoPrecioReal(double productoPrecioReal) {
		this.productoPrecioReal = productoPrecioReal;
	}
	public double getProductoPrecioVirtual() {
		return productoPrecioVirtual;
	}
	public void setProductoPrecioVirtual(double productoPrecioVirtual) {
		this.productoPrecioVirtual = productoPrecioVirtual;
	}

	public String getProductoDescripcion() {
		return productoDescripcion;
	}

	public void setProductoDescripcion(String productoDescripcion) {
		this.productoDescripcion = productoDescripcion;
	}

	public BigDecimal getProductoCategoria() {
		return productoCategoria;
	}

	public void setProductoCategoria(BigDecimal productoCategoria) {
		this.productoCategoria = productoCategoria;
	}

	public BigDecimal getProductoVendedor() {
		return productoVendedor;
	}

	public void setProductoVendedor(BigDecimal productoVendedor) {
		this.productoVendedor = productoVendedor;
	}

	public BigDecimal getProductoGanador() {
		return productoGanador;
	}

	public void setProductoGanador(BigDecimal productoGanador) {
		this.productoGanador = productoGanador;
	}

	public String getS_productoTiempoInicial() {
		return s_productoTiempoInicial;
	}

	public void setS_productoTiempoInicial(String s_productoTiempoInicial) {
		this.s_productoTiempoInicial = s_productoTiempoInicial;
	}

	public String getS_productoTiempoFinal() {
		return s_productoTiempoFinal;
	}

	public void setS_productoTiempoFinal(String s_productoTiempoFinal) {
		this.s_productoTiempoFinal = s_productoTiempoFinal;
	}

	public String getProductoImagen() {
		return productoImagen;
	}

	public void setProductoImagen(String productoImagen) {
		this.productoImagen = productoImagen;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//return new Gson().toJson(this);
		return gson.toJson(this);
	}
}
