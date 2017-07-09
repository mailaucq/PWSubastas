package com.subastas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.subastas.service.ImageService;

@Controller
public class ImagenController {

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public @ResponseBody
    String uploadImage( HttpServletRequest request) {
		return imageService.upload(request);
	}
}