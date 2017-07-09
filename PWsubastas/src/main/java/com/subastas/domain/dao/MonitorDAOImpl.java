package com.subastas.domain.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Monitor;
@Component("monitorDAO")
public class MonitorDAOImpl extends GenericDAOImpl<Monitor,BigDecimal> implements MonitorDAO {
}
