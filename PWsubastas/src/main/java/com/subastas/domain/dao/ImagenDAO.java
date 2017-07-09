package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import com.subastas.domain.to.Imagen;

public interface ImagenDAO extends GenericDAO<Imagen, BigDecimal>{
	public List<Imagen> getImagenXProducto(BigDecimal productoId);
	public List<Imagen> getImagenes();
}

