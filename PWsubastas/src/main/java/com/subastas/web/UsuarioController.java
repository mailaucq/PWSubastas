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
import com.subastas.domain.to.Usuario;
import com.subastas.service.ProductoService;
import com.subastas.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value="/registro.htm", method = RequestMethod.GET)
	public String registro(ModelMap model)
	{
		model.addAttribute(new Usuario());
		return "registro.jsp";
	}
	@RequestMapping(value = "/addUsuario.htm", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario) {
		System.out.println(usuario.getUsuarioNombre());
		usuarioService.add(usuario);
		return "redirect:login.htm";
	}

	@RequestMapping(value = "/login.htm")
	public String login(ModelMap model) {
		model.addAttribute(new Usuario());
		return "login.jsp";
	}
	
	@RequestMapping(value = "/logout.htm")
	public String logout(ModelMap model) {
		model.addAttribute(new Usuario());
		return "redirect:home.htm";
	}
	
	@RequestMapping(value = "/secured/usuario.htm", method = RequestMethod.GET)
	public String usuario(ModelMap model){
		String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
		Usuario usuario = usuarioService.findUsuarioByName(usuarioNombre);
		List<Producto> productos = productoService.getProductoXVendedor(usuario.getUsuarioId());
		model.addAttribute("saldo", usuario.getUsuarioSaldo());
		model.addAttribute("numProductos", productos.size());
		return "usuario.jsp";
	}
	
	@RequestMapping(value = "/secured/homeusuario.htm")
	public ModelAndView homeusuario(
			@RequestParam(value = "accion", required = false) String accion,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("/secured/homeusuario.jsp");
	    List<Producto> productos = null;
	    if(accion != null){
			if(accion.equals("buscar")){
				productos = productoService.getProductos(word);
			}else if(accion.equals("producto")){
				Producto producto = productoService.findById(new BigDecimal(Integer.parseInt(id)));
				productos = new ArrayList<Producto>();
				productos.add(producto);
			}else{
				productos = productoService.getProductos();
			}
	    }
		else{
			productos = productoService.getProductos();
		}
	    mv.addObject("productos", productos);
	    return mv;
	}
	
	@RequestMapping(value = "/home.htm")
	public ModelAndView home(
			@RequestParam(value = "accion", required = false) String accion,
			@RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("/home.jsp");
	    List<Producto> productos = null;
	    if(accion != null){
			if(accion.equals("buscar")){
				productos = productoService.getProductos(word);
			}else if(accion.equals("producto")){
				Producto producto = productoService.findById(new BigDecimal(Integer.parseInt(id)));
				productos = new ArrayList<Producto>();
				productos.add(producto);
			}else{
				productos = productoService.getProductos();
			}
	    }
		else{
			productos = productoService.getProductos();
		}
	    mv.addObject("productos", productos);
	    return mv;
	}
}