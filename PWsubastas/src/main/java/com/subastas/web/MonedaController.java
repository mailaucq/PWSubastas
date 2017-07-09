package com.subastas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.subastas.domain.to.Moneda;
import com.subastas.service.MonedaService;

@Controller
public class MonedaController {

	@Autowired
	private MonedaService monedaService;
	
	@RequestMapping(value="/secured/comprarmoneda.htm", method = RequestMethod.GET)
	public String registro(ModelMap model)
	{
		model.addAttribute(new Moneda());
		return "comprarmoneda.jsp";
	}
	
	@RequestMapping(value = "/secured/doComprarMoneda.htm", method = RequestMethod.POST)
	public String doComprarMoneda(@ModelAttribute("moneda") Moneda moneda) {
		monedaService.addSaldoCurrentUsuario(moneda.getMonedaId());
		return "redirect:/secured/usuario.htm";
	}
	
	@RequestMapping(value = "/secured/exchangeRate.htm", method = RequestMethod.POST)
	public @ResponseBody String exchangeRate(
			@RequestParam(value = "currency", required = false) String tipoMoneda) {
		return "" + monedaService.exchangeRate(tipoMoneda);
	}
	
}