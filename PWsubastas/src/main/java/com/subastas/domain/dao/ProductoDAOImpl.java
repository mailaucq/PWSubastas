package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Producto;
@Component("productoDAO")
public class ProductoDAOImpl extends GenericDAOImpl<Producto, BigDecimal> implements ProductoDAO {
	@SuppressWarnings("unchecked")
	public List<Producto> getProductos(String palabra) {
		List<Producto> productos = new ArrayList<Producto>();
		try {
		      entityManager.getTransaction().begin();
		      productos = entityManager.createQuery("from Producto p WHERE productoNombre LIKE '%"	+ palabra + "%'").getResultList();
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	    	  entityManager.getTransaction().rollback();
	    }
		return productos;
	}

	public void updatePrecio(double precio,int productoId){
		try {
		      entityManager.getTransaction().begin();
		      Producto producto = (Producto) entityManager.find(Producto.class, productoId);
		      producto.setProductoPrecioVirtual(precio);
		      entityManager.getTransaction().commit();
		 } catch (Exception e) {
		      entityManager.getTransaction().rollback();
		 }
	}

	@SuppressWarnings("unchecked")
	public List<Producto> getProductoXVendedor(BigDecimal idUsuario) {
		List<Producto> productos = new ArrayList<Producto>();
		try {
		      entityManager.getTransaction().begin();
		      productos = entityManager.createQuery("from Producto p WHERE producto_vendedor=" + idUsuario + "").getResultList();
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	    	  entityManager.getTransaction().rollback();
	    }
		return productos;
	}
	
	public BigDecimal getMaxId(){
		BigDecimal id=BigDecimal.ZERO;
		try {
		      entityManager.getTransaction().begin();
		      id = (BigDecimal) entityManager.createQuery("select max(productoId) from Producto p").getSingleResult();
		      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	    	  entityManager.getTransaction().rollback();
	    }
		if(id == null){
			id=BigDecimal.ZERO;
		}
		return id.add(BigDecimal.ONE);
	}
}
