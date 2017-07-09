package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Consulta;

@Component("consultasDAO")
public class ConsultasDAOImpl extends GenericDAOImpl<Consulta,BigDecimal> implements ConsultasDAO {
	@SuppressWarnings("unchecked")
	public List<Consulta> getConsultaXNombre(String bynombre) {
		List<Consulta> consultas = new ArrayList<Consulta>();
		try {
		      entityManager.getTransaction().begin();
		      consultas = (List<Consulta> )entityManager.createQuery("from Consulta c  WHERE c.nombre ='"+bynombre+"'").getResultList();  
		      entityManager.getTransaction().commit();
		      
		    } catch (Exception e) {
		      entityManager.getTransaction().rollback();
		    }
		return consultas;
	}
}

