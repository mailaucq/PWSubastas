package com.subastas.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.subastas.domain.dao.ProductoDAO;
import com.subastas.domain.to.Producto;
import com.subastas.domain.to.Tags;
import com.subastas.service.ImageService;
import com.subastas.service.ProductoService;
import com.subastas.service.UserItemTagService;

@Controller
public class ProductoController {
	private float value = 10;
	@Autowired
	ProductoService productoService;
	@Autowired
	ImageService imageService;
	@Autowired
	ProductoDAO productoDAO;
	@Autowired
	UserItemTagService userItemTagService;
	@RequestMapping(value="/secured/producto.htm", method = RequestMethod.GET)
	public String registro(ModelMap model)
	{
		model.addAttribute(new Producto());
		return "agregarProducto.jsp";
	}
	@RequestMapping(value = "/secured/addProducto.htm", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("producto") Producto producto) {
		productoService.add(producto);		
		System.out.println(producto.getProductoDescripcion());
		return "redirect:/secured/usuario.htm";
	}
	
	@RequestMapping(value = "/secured/productoDescripcion.htm")
	public ModelAndView productoDescripcion(@RequestParam(value = "id", required = false) String id){
		ModelAndView mv = new ModelAndView("/secured/producto.jsp");
		System.out.println("id : "+id);
		Producto producto = productoService.findById(new BigDecimal(Integer.parseInt(id)));
	    mv.addObject("producto", producto);
	    List<Tags> tags = userItemTagService.findTagsByProductoId(producto.getProductoId());
	    mv.addObject("tags", tags);
	    List<Producto> productos = productoService.recomendarProductosSimilares(producto.getProductoId()); 
	    mv.addObject("productosSimilares", productos);
		return mv;
	}
	
	@RequestMapping(value = "/secured/recomendarProductosUsuario.htm", method = RequestMethod.GET)
	public ModelAndView recomendarProductosUsuario(){
		ModelAndView mv = new ModelAndView("/secured/homeusuario.jsp");
	    List<Producto> productos = productoService.recomendarProductosCurrentUsuario(); 
	    mv.addObject("productos", productos);
		return mv;
	}
	
//	@RequestMapping(value = "/secured/recomendarProductosSimilares.htm", method = RequestMethod.GET)
//	public ModelAndView recomendarProductosSimilares(){
//		ModelAndView mv = new ModelAndView("/secured/producto.jsp");
//	    List<Producto> productos = productoService.recomendarProductosCurrentUsuario(); 
//	    mv.addObject("productos", productos);
//		return mv;
//	}
}