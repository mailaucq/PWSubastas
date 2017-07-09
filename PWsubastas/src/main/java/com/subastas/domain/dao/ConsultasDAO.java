package com.subastas.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import com.subastas.domain.to.Consulta;


public interface ConsultasDAO extends GenericDAO<Consulta,BigDecimal>  {
	public List<Consulta> getConsultaXNombre(String bynombre);
}

