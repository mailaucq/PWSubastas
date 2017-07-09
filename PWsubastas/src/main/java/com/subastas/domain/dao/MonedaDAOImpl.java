package com.subastas.domain.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Moneda;
@Component("monedaDAO")
public class MonedaDAOImpl extends GenericDAOImpl<Moneda,BigDecimal> implements MonedaDAO {
}
