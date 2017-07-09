package com.subastas.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.subastas.domain.to.Producto;


public interface ProductoService {

	public void add(Producto producto);

	public List<Producto> getProductoXVendedor(BigDecimal usuarioId);

	public List<Producto> getProductos();

	public List<Producto> getProductos(String word);

	public Producto findById(BigDecimal bigDecimal);

	public List<Producto> recomendarProductosCurrentUsuario();

	public Map<BigDecimal, List<Producto>> recomendarProductosBetweenUserItem();

	public Map<BigDecimal, List<Producto>> recomendarProductosBetweenItem();

	public List<Producto> recomendarProductosSimilares(BigDecimal productoId);
}