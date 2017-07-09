package com.subastas.domain.to;

public class Estado {
	private int estadoId;
	private String estadoValor;
	private String estadoDescripcion;
		
	
	public Estado() {
		super();
	}
	
	public Estado(int estadoId, String estadoValor, String estadoDescripcion) {
		super();
		this.estadoId = estadoId;
		this.estadoValor = estadoValor;
		this.estadoDescripcion = estadoDescripcion;
	}
	
	public int getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}
	public String getEstadoValor() {
		return estadoValor;
	}
	public void setEstadoValor(String estadoValor) {
		this.estadoValor = estadoValor;
	}
	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}
	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}
	
	
}
