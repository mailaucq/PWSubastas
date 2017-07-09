package com.subastas.web;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.subastas.domain.to.Imagen;
import com.subastas.service.ImageService;
 
@Component("imageServlet")
public class ImageServlet implements HttpRequestHandler {
 
    @Autowired
    private ImageService imageService;
    
    @Override
    public void handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // get the thumb from the user entity
    	BigDecimal id = new BigDecimal(request.getParameter("id"));
    	byte[] thumb = null;
    	Imagen imagen = imageService.getImagenes().get(id);
    	if(imagen != null){
    		thumb = imagen.getImagen();
    		
    		InputStream in = new ByteArrayInputStream(thumb);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			Image myImage = Toolkit.getDefaultToolkit().createImage(bImageFromConvert.getSource());
			BufferedImage newImage = resizeImage(myImage,200,200);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( newImage, "jpg", baos );
			baos.flush();
			
			thumb = baos.toByteArray();
			baos.close();		
	    	
	        String name = imagen.getImagenId().toString();
	        response.setContentType("image/jpg");
	        response.setContentLength(thumb.length);
	 
	        response.setHeader("Content-Disposition", "inline; filename=\"" + name
	                + "\"");
	 
	        BufferedInputStream input = null;
	        BufferedOutputStream output = null;
	 
	        try {
	            input = new BufferedInputStream(new ByteArrayInputStream(thumb));
	            output = new BufferedOutputStream(response.getOutputStream());
	            byte[] buffer = new byte[8192];
	            int length;
	            while ((length = input.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	        } catch (IOException e) {
	            System.out.println("There are errors in reading/writing image stream "
	                    + e.getMessage());
	        } finally {
	            if (output != null)
	                try {
	                    output.close();
	                } catch (IOException ignore) {
	                }
	            if (input != null)
	                try {
	                    input.close();
	                } catch (IOException ignore) {
	                }
	        }
    	}
    }
	 public static BufferedImage resizeImage(Image image, int width, int height) {
	        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        final Graphics2D graphics2D = bufferedImage.createGraphics();
	        graphics2D.setComposite(AlphaComposite.Src);
	        graphics2D.drawImage(image, 0, 0, width, height, null);
	        graphics2D.dispose();
	 
	        return bufferedImage;
	   }
}