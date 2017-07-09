package com.subastas.service;

import java.math.BigDecimal;



public interface MonedaService {

	public String addSaldoCurrentUsuario(BigDecimal monedaId);
	public double exchangeRate(String tipoMoneda);
}