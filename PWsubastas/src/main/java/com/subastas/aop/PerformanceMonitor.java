package com.subastas.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import com.subastas.domain.dao.MonitorDAO;
import com.subastas.service.UsuarioService;

@Aspect
public class PerformanceMonitor {
	private final String MONITOR = "PERFORMANCE_MONITOR";
	private Monitor monitor_i;
	@Autowired
	MonitorDAO monitorDAO;
	@Autowired
	UsuarioService usuarioService;
	@Before("execution(* com.subastas.domain.dao.GenericDAO.*(..))")
	public void startMonitor(JoinPoint joinPoint) {
		for (Object object : joinPoint.getArgs()) {
			if (!(object instanceof com.subastas.domain.to.Monitor)) {
				monitor_i = MonitorFactory.start(MONITOR);
			}
		}
	}

	@After("execution(* com.subastas.domain.dao.GenericDAO.*(..))")
	public void stopMonitor(JoinPoint joinPoint) {
		for (Object object : joinPoint.getArgs()) {
			if (!(object instanceof com.subastas.domain.to.Monitor)) {
				monitor_i.stop();
			}
		}		
	}

	public Date getLastAccess() {
		return monitor_i.getLastAccess();
	}

	public int getCallCount() {
		return (int) monitor_i.getHits();
	}

	public double getAverageCallTime() {
		return monitor_i.getAvg() / 1000;
	}

	public double getLastCallTime() {
		return monitor_i.getLastValue() / 1000;
	}

	public double getMaximumCallTime() {
		return monitor_i.getMax() / 1000;
	}

	public double getMinimumCallTime() {
		return monitor_i.getMin() / 1000;
	}

	public double getTotalCallTime() {
		return monitor_i.getTotal() / 1000;
	}

	@After("execution(* com.subastas.domain.dao.GenericDAO.*(..))")
	public void log(JoinPoint joinPoint_p) {
		Advised advised = (Advised) joinPoint_p.getThis();
	    Class<?> cls = advised.getTargetSource().getTargetClass();
	    String nameClass = cls.getName();
		for (Object object : joinPoint_p.getArgs()) {
			if (!(object instanceof com.subastas.domain.to.Monitor) && !(object instanceof com.subastas.domain.to.Imagen)) {
				String usuarioNombre = usuarioService.getCurrentUsuarioNombre();
				com.subastas.domain.to.Monitor monitor = new com.subastas.domain.to.Monitor();
				monitor.setClassName(nameClass);
				monitor.setMethodName(joinPoint_p.getSignature().getName());
				monitor.setExecutionDate(this.getLastAccess());
				monitor.setLastExecutionTime(this.getLastCallTime() + " sec");
				monitor.setServiceCalls(this.getCallCount());
			    monitor.setAvgExecutionTime(this.getAverageCallTime() + " sec");
				monitor.setTotalExecutionTime(this.getTotalCallTime() + " sec");
				monitor.setMinExecutionTime(this.getMinimumCallTime() + " sec");
				monitor.setMaxExecutionTime(this.getMaximumCallTime() + " sec");
				monitor.setUsuarioNombre(usuarioNombre);
				monitorDAO.update(monitor);
			}
		}		
	}
}