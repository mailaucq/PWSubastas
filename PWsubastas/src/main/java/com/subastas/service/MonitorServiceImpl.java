package com.subastas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.MonitorDAO;
import com.subastas.domain.to.Monitor;

@Service
public class MonitorServiceImpl implements MonitorService {
	@Autowired
	MonitorDAO monitorDAO;
    public List<Monitor> getLogs() {
		return monitorDAO.findByNamedQuery("Monitor.orderByExecutionDateAsc");
	}

}