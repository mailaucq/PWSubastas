package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Imagen;
@Component("imagenDAO")
public class ImagenDAOImpl extends GenericDAOImpl<Imagen, BigDecimal> implements ImagenDAO {
	@SuppressWarnings("unchecked")
	
	public List<Imagen> getImagenXProducto(BigDecimal productoId){
		List<Imagen> imagenes  = new ArrayList<Imagen>();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			
			tx.begin();
		     
		      imagenes = (List<Imagen> )entityManager.createQuery("from Imagen i WHERE i.imagenProducto =" + productoId + "").getResultList();  
		      tx.commit();
		      
		    } catch (Exception e) {
		      tx.rollback();
		    }
		
		return imagenes; 
	}
	public List<Imagen> getImagenes(){
		List<Imagen> imagenes  = new ArrayList<Imagen>();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			
			tx.begin();
		     
		      imagenes = (List<Imagen> )entityManager.createQuery("from Imagen i").getResultList();  
		      tx.commit();
		      
		    } catch (Exception e) {
		      tx.rollback();
		    }
		
		return imagenes; 
	}
}
