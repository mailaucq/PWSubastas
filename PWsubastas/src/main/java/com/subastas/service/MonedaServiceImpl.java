package com.subastas.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.MonedaDAO;
import com.subastas.domain.to.Moneda;
import com.subastas.domain.to.Usuario;
import com.subastas.webService.Currency;
import com.subastas.webService.CurrencyService;

@Service
public class MonedaServiceImpl implements MonedaService {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	MonedaDAO monedaDao;
    public String addSaldoCurrentUsuario(BigDecimal monedaId) {
		Moneda moneda = monedaDao.findById(Moneda.class, monedaId);
		String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
		Usuario usuario = usuarioService.findUsuarioByName(usuarioNombre);
	    BigDecimal saldo = usuario.getUsuarioSaldo().add(moneda.getMonedaValorVirtual());
	    usuarioService.updateUsuarioXSaldo(usuario.getUsuarioId(), saldo);
		return ""+saldo;
	}
    
    public double exchangeRate(String tipoMoneda){
    	CurrencyService c;
    	double conversion = 1.0;
		try {
			c = new CurrencyService();
			System.out.println(tipoMoneda);
			if(tipoMoneda.equalsIgnoreCase("USD")){
				conversion = c.conversion(Currency.USD, Currency.PEN);
			}
			else if (tipoMoneda.equalsIgnoreCase("EUR")){
				conversion = c.conversion(Currency.EUR, Currency.PEN);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conversion;
    }

}