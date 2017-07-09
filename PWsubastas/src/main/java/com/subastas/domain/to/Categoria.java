package com.subastas.domain.to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Categoria {
	private int categoriaId;
	private String categoriaNombre;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(int categoriaId, String categoriaNombre) {
		super();
		this.categoriaId = categoriaId;
		this.categoriaNombre = categoriaNombre;
	}
	
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoriaNombre() {
		return categoriaNombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
