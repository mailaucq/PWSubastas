package com.subastas.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subastas.domain.dao.ImagenDAO;
import com.subastas.domain.to.Imagen;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImagenDAO imagenDAO;
	static Map<BigDecimal,Imagen> imagenes = null;
	@Override
	public String upload(HttpServletRequest request) {
		File file;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;
		ServletContext context = request.getSession().getServletContext();
		String filePath = context.getInitParameter("file-upload");
		filePath = context.getRealPath("/")+"resources/productimages/";
		String fieldName = "";
		String fileName = "";
		String contentType = request.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			try {
				// Parse the request to get file items.
				List fileItems = upload.parseRequest(request);
				// Process the uploaded file items
				Iterator i = fileItems.iterator();
				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						fieldName = fi.getFieldName();
						fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath
									+ fileName.substring(fileName
											.lastIndexOf("\\")));
						} else {
							file = new File(filePath
									+ fileName.substring(fileName
											.lastIndexOf("\\") + 1));
						}
						fi.write(file);
					} else {
						String a = (String) i.next();
					}
				}
				request.setAttribute("imagePath", filePath + fileName);
				imagenes = null;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			System.out.println(filePath + fileName);
			return filePath + fileName;

		} else {
			return "<html>" + "<head>" + "<title>Servlet upload</title>"
					+ "</head>" + "<body>" + "<p>No file uploaded</p>"
					+ "</body>" + "</html>";
		}

	}
	public Imagen findByProductoId(BigDecimal id){
		List<Imagen> imagenes  = imagenDAO.getImagenXProducto(id);
		if(imagenes.size()>0){
			return imagenes.get(0);
		}
		return null;
	}
	
	public Map<BigDecimal,Imagen> getImagenes(){
		if(imagenes == null){
			imagenes  = new HashMap<BigDecimal,Imagen>();
			List<Imagen> imagenesList = imagenDAO.getImagenes();
			for (Iterator iterator = imagenesList.iterator(); iterator.hasNext();) {
				Imagen imagen = (Imagen) iterator.next();
				imagenes.put(imagen.getImagenProducto(), imagen);
			}
		}
		return imagenes;
	}
}