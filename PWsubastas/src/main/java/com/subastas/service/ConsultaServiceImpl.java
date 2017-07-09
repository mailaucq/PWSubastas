package com.subastas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.ConsultasDAO;
import com.subastas.domain.to.Consulta;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	@Autowired
	private ConsultasDAO consultaDAO;

	@Override
	public void add(Consulta consulta) {
		consultaDAO.create(consulta);
	}

}