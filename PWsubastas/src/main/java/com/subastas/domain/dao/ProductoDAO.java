package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import com.subastas.domain.to.Producto;

public interface ProductoDAO extends GenericDAO<Producto,BigDecimal> {
	public List<Producto> getProductos(String palabra);
	public void updatePrecio(double precio,int productoId);
	public List<Producto> getProductoXVendedor(BigDecimal idUsuario);
	public BigDecimal getMaxId();
}
