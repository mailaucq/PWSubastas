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
@Table(name = "Moneda")
public class Moneda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "moneda_id")
	private BigDecimal monedaId;
	@Column(name = "moneda_valorreal")
	private BigDecimal monedaValorReal;
	@Column(name = "moneda_valorvirtual")
	private BigDecimal monedaValorVirtual;
	@Column(name = "moneda_nombre")
	private String monedaNombre;
	@Column(name = "moneda_simbolo")
	private String monedaSimbolo;
	
	public Moneda() {
		super();
	}
	
	public Moneda(BigDecimal monedaId, BigDecimal monedaValorReal,
			BigDecimal monedaValorVirtual, String monedaNombre, String monedaSimbolo) {
		super();
		this.monedaId = monedaId;
		this.monedaValorReal = monedaValorReal;
		this.monedaValorVirtual = monedaValorVirtual;
		this.monedaNombre = monedaNombre;
		this.monedaSimbolo = monedaSimbolo;
	}
	
	public Moneda(BigDecimal monedaId, BigDecimal monedaValorReal,
			BigDecimal monedaValorVirtual) {
		super();
		this.monedaId = monedaId;
		this.monedaValorReal = monedaValorReal;
		this.monedaValorVirtual = monedaValorVirtual;
	}


	public BigDecimal getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(BigDecimal monedaId) {
		this.monedaId = monedaId;
	}
	public BigDecimal getMonedaValorReal() {
		return monedaValorReal;
	}
	public void setMonedaValorReal(BigDecimal monedaValorReal) {
		this.monedaValorReal = monedaValorReal;
	}
	public BigDecimal getMonedaValorVirtual() {
		return monedaValorVirtual;
	}
	public void setMonedaValorVirtual(BigDecimal monedaValorVirtual) {
		this.monedaValorVirtual = monedaValorVirtual;
	}

	public String getMonedaNombre() {
		return monedaNombre;
	}

	public void setMonedaNombre(String monedaNombre) {
		this.monedaNombre = monedaNombre;
	}

	public String getMonedaSimbolo() {
		return monedaSimbolo;
	}

	public void setMonedaSimbolo(String monedaSimbolo) {
		this.monedaSimbolo = monedaSimbolo;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

}
