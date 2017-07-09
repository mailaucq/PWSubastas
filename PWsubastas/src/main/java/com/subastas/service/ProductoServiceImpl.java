package com.subastas.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.ImagenDAO;
import com.subastas.domain.dao.ProductoDAO;
import com.subastas.domain.to.Imagen;
import com.subastas.domain.to.Producto;
import com.subastas.domain.to.Tags;
import com.subastas.domain.to.Usuario;

@Service
public class ProductoServiceImpl implements ProductoService {
	private SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	@Autowired
	ProductoDAO productoDAO;
	private Imagen imagen = new Imagen();
	@Autowired
	ImagenDAO imagenDAO;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	UserItemTagService userItemTagService;
	
	@Override
	public void add(Producto producto) {
		Date d_tiempoFin=null,d_tiempoInicial = null;
		try {
			d_tiempoFin = dt1.parse(producto.getS_productoTiempoFinal());
			producto.setProductoTiempoFinal(d_tiempoFin);
			d_tiempoInicial = dt1.parse(producto.getS_productoTiempoInicial());
			producto.setProductoTiempoFinal(d_tiempoInicial);
			String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
			Usuario usuario = usuarioService.findUsuarioByName(usuarioNombre);
			producto.setProductoVendedor(usuario.getUsuarioId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BigDecimal maxProductoId=productoDAO.getMaxId();
		
		imagen.setImagenProducto(maxProductoId);
		imagen.setImagenUrl(producto.getProductoImagen());
		try {
			File imgPath = new File(producto.getProductoImagen());
			byte[] bytes = Utils.ImageToByte(imgPath);
			imagen.setImagen(bytes);
			imagenDAO.create(imagen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productoDAO.create(producto);
	}

	@Override
	public List<Producto> getProductoXVendedor(BigDecimal usuarioId) {
		List<Producto> productos = productoDAO.getProductoXVendedor(usuarioId);
		return productos;
	}

	@Override
	public List<Producto> getProductos() {
		List<Producto> productos = productoDAO.findAll(Producto.class);
		return productos;
	}

	@Override
	public List<Producto> getProductos(String word) {
		List<Producto> productos = productoDAO.getProductos(word);
		return productos;
	}

	@Override
	public Producto findById(BigDecimal id) {
		Producto producto = productoDAO.findById(Producto.class, id);
		return producto;
	}
	
	@Override
	public List<Producto> recomendarProductosSimilares(BigDecimal productoId){
		return this.recomendarProductosBetweenItem().get(productoId);
	}

	@Override
	public List<Producto> recomendarProductosCurrentUsuario() {
		String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
		Usuario usuarioCurrent = usuarioService.findUsuarioByName(usuarioNombre);
		return this.recomendarProductosBetweenUserItem().get(usuarioCurrent.getUsuarioId());
	}
	@Override
	public Map<BigDecimal,List<Producto>> recomendarProductosBetweenItem() {
		List<Producto> productos = productoDAO.findAll(Producto.class);
		List<Tags> tags = userItemTagService.findAll();
		double[][] productoTag = new double[productos.size()][tags.size()];
		double []sumaCuadrados = new double[productos.size()];
		Map<BigDecimal,List<Producto>> maxRecomendations = new HashMap<>(); 
		double umbral = 0.5;
		double [][]recomendationItem = new double[productos.size()][productos.size()];
		int i=0;
		for (Iterator<Producto> iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			List<Object[]> valueTags = userItemTagService.findTagsCountByItem(producto.getProductoId());
			int j =0;
			double sumaCua = 0;
			if(valueTags.size()>0){
				for (Iterator<Tags> iterator2 = tags.iterator(); iterator2.hasNext();) {
					Tags tag = iterator2.next();
					for (int k = 0; k < valueTags.size(); k++) {
						if(tag.getTagId().equals(valueTags.get(k)[0])){
							productoTag[i][j] = ((Long)valueTags.get(k)[2]).doubleValue();
							sumaCua+=productoTag[i][j]*productoTag[i][j];
						}
					}
					j++;
				}
			}
			sumaCuadrados[i]=Math.sqrt(sumaCua);
			i++;
		}
		/**
		 * Normalized
		 */
		for (int j = 0; j < productoTag.length; j++) {
			for (int j2 = 0; j2 < productoTag[0].length; j2++) {
				if(sumaCuadrados[j]>0){
					productoTag[j][j2]=productoTag[j][j2]/sumaCuadrados[j];
				}
			}
		}
		for (int j = 0; j < productos.size(); j++) {
			List max = new ArrayList<>();
			for (int j2 = 0; j2 < productos.size(); j2++) {
				double suma = 0;
				for (int j3 = 0; j3 < tags.size(); j3++) {
					suma += productoTag[j][j3]*productoTag[j2][j3];
				}
				recomendationItem[j][j2] = suma;
				if(suma > umbral){
					System.out.println(productos.get(j2).getProductoNombre()+ " " + suma);
					max.add(productos.get(j2));
				}
			}
			maxRecomendations.put(productos.get(j).getProductoId(),max);
		}
		
		return maxRecomendations;
	}
	@Override
	public Map<BigDecimal, List<Producto>> recomendarProductosBetweenUserItem(){
		List<Producto> productos = productoDAO.findAll(Producto.class);
		List<Usuario> usuarios = usuarioService.findAll();
		List<Tags> tags = userItemTagService.findAll();
		double[][] userTag = new double[usuarios.size()][tags.size()];
		double[][] productoTag = new double[productos.size()][tags.size()];
		Map<BigDecimal, List<Producto>> maxUserRecomendations = new HashMap();
		double[][]recomendationItemUser = new double[usuarios.size()][productos.size()];
		double []sumaCuadradosUserTag = new double[usuarios.size()];
		double []sumaCuadradosProductoTag = new double[productos.size()];
		double umbral = 0.5;
		int i=0;
		for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = iterator.next();
			List<Object[]> valueTags = userItemTagService.findTagsCountByUsuario(usuario.getUsuarioId());
			int j =0;
			double sumaCua = 0;
			if(valueTags.size()>0){
				for (Iterator<Tags> iterator2 = tags.iterator(); iterator2.hasNext();) {
					Tags tag = iterator2.next();
					for (int k = 0; k < valueTags.size(); k++) {
						if(tag.getTagId().equals(valueTags.get(k)[0])){
							userTag[i][j] = ((Long)valueTags.get(k)[2]).doubleValue();
							sumaCua+=userTag[i][j]*userTag[i][j];
						}
					}
					j++;
				}
			}
			sumaCuadradosUserTag[i]=Math.sqrt(sumaCua);
			i++;
		}
		/**
		 * Normalized
		 */
		for (int j = 0; j < userTag.length; j++) {
			for (int j2 = 0; j2 < userTag[0].length; j2++) {
				if(sumaCuadradosUserTag[j]>0){
					userTag[j][j2]=userTag[j][j2]/sumaCuadradosUserTag[j];
				}
			}
		}
		i=0;
		for (Iterator<Producto> iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			List<Object[]> valueTags = userItemTagService.findTagsCountByItem(producto.getProductoId());
			int j =0;
			double sumaCua = 0;
			if(valueTags.size()>0){
				for (Iterator<Tags> iterator2 = tags.iterator(); iterator2.hasNext();) {
					Tags tag = iterator2.next();
					for (int k = 0; k < valueTags.size(); k++) {
						if(tag.getTagId().equals(valueTags.get(k)[0])){
							productoTag[i][j] = ((Long)valueTags.get(k)[2]).doubleValue();
							sumaCua+=productoTag[i][j]*productoTag[i][j];
						}
					}
					j++;
				}
			}
			sumaCuadradosProductoTag[i]=Math.sqrt(sumaCua);
			i++;
		}
		/**
		 * Normalized
		 */
		for (int j = 0; j < productoTag.length; j++) {
			for (int j2 = 0; j2 < productoTag[0].length; j2++) {
				if(sumaCuadradosProductoTag[j]>0){
					productoTag[j][j2]=productoTag[j][j2]/sumaCuadradosProductoTag[j];
				}
			}
		}
		for (int j = 0; j < usuarios.size(); j++) {
			List max = new ArrayList<>();
			for (int j2 = 0; j2 < productos.size(); j2++) {
				double suma = 0;
				for (int j3 = 0; j3 < tags.size(); j3++) {
					suma += userTag[j][j3]*productoTag[j2][j3];
				}
				recomendationItemUser[j][j2]=suma;
				if (suma>umbral) {
					System.out.println(productos.get(j2).getProductoNombre()+ " " + suma);
					max.add(productos.get(j2));
				}
			}
			maxUserRecomendations.put(usuarios.get(j).getUsuarioId(), max);
		}
		return maxUserRecomendations;
	}
}