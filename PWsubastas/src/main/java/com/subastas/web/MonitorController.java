package com.subastas.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.subastas.domain.to.Monitor;
import com.subastas.service.MonitorService;

@Controller
public class MonitorController {

	@Autowired
	private MonitorService monitorService;

	@RequestMapping(value="/secured/showmonitor.htm")
	public ModelAndView renderTableLogs() {
	    ModelAndView mv = new ModelAndView("/secured/monitor.jsp"); 
	    List<Monitor> objects = monitorService.getLogs(); 
	    mv.addObject("objects", objects);
	    return mv;
	}
	
	
}