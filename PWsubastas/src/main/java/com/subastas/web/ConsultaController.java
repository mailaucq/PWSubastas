package com.subastas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.subastas.domain.to.Consulta;
import com.subastas.service.ConsultaService;


@Controller
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	@RequestMapping(value="/contactar.htm", method = RequestMethod.GET)
	public String contactar(ModelMap model)
	{
		model.addAttribute(new Consulta());
		return "consulta.jsp";
	} 
	@RequestMapping(value = "/addConsulta.htm",method = RequestMethod.POST)
	public String addConsulta(@ModelAttribute("consulta") Consulta consulta) {

		consultaService.add(consulta);
		System.out.println("Se llego a insertar la consulta");
		return "redirect:home.htm";

	}
}