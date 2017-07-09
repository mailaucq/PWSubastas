package com.subastas.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.subastas.domain.to.Producto;
import com.subastas.domain.to.Tags;
import com.subastas.domain.to.UserItemTag;
import com.subastas.service.UserItemTagService;

@Controller
public class UserItemTagController {

	@Autowired
	private UserItemTagService userItemTagService;
	@RequestMapping(value = "/secured/doCrearTags.htm", method = RequestMethod.POST)
	public String doCrearTags(@ModelAttribute("tags") Tags tags) {
		userItemTagService.addUserItemTagCurrentUsuario(tags);
		return "redirect:/secured/productoDescripcion.htm?id="+tags.getProductoId();
	}
	@RequestMapping(value = "/secured/showMyTags.htm", method = RequestMethod.GET)
	public ModelAndView showMyTags() {
		ModelAndView mv = new ModelAndView("/secured/showMyTags.jsp");
	    List<Tags> tags = userItemTagService.findTagsByCurrentUsuario(); 
	    mv.addObject("tags", tags);
	    return mv;
	}	
	@RequestMapping(value = "/secured/agregarTag.htm", method = RequestMethod.GET)
	public String agregarTag(@RequestParam(value = "id", required = false) BigDecimal productoId, ModelMap model) {
		Tags tags = new Tags();
		tags.setProductoId(productoId);
		model.addAttribute(tags);
		return "agregarTag.jsp";
	}		
}