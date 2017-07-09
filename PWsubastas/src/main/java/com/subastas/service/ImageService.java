package com.subastas.service;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.subastas.domain.to.Imagen;


public interface ImageService {

	public String upload(HttpServletRequest request);
	public Imagen findByProductoId(BigDecimal id);
	public Map<BigDecimal,Imagen> getImagenes();
}