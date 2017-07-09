package com.subastas.domain.to;

public class Rol {
	private int rolId;
	private String rolName;
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rol(int rolId, String rolName) {
		super();
		this.rolId = rolId;
		this.rolName = rolName;
	}
	public int getRolId() {
		return rolId;
	}
	public void setRolId(int rolId) {
		this.rolId = rolId;
	}
	public String getRolName() {
		return rolName;
	}
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
}
