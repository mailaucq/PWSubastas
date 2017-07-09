package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity
@Table(name = "Monitor")
@NamedQuery(name="Monitor.orderByExecutionDateAsc", query="SELECT m FROM Monitor m ORDER BY m.executionDate DESC")
public class Monitor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "log_id_seq")
	@SequenceGenerator(name = "log_id_seq", sequenceName = "monitor_log_id_seq")
	@Column(name = "log_id")
	private BigDecimal logId;
	@Column(name = "class_name")
	private String className;
	@Column(name = "method_name")
	String methodName;
	@Column(name = "execution_date")
	private Date executionDate;
	@Column(name = "last_execution_time")
	String lastExecutionTime;
	@Column(name = "service_calls")
	double serviceCalls;
	@Column(name = "avg_execution_time")
	String avgExecutionTime;
	@Column(name = "total_execution_time")
	String totalExecutionTime;
	@Column(name = "min_execution_time")
	String minExecutionTime;
	@Column(name = "max_execution_time")
	String maxExecutionTime;
	@Column(name = "usuario_nombre")
	String usuarioNombre;
	
	public BigDecimal getLogId() {
		return logId;
	}

	public void setLogId(BigDecimal logId) {
		this.logId = logId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getLastExecutionTime() {
		return lastExecutionTime;
	}

	public void setLastExecutionTime(String lastExecutionTime) {
		this.lastExecutionTime = lastExecutionTime;
	}

	public double getServiceCalls() {
		return serviceCalls;
	}

	public void setServiceCalls(double serviceCalls) {
		this.serviceCalls = serviceCalls;
	}

	public String getAvgExecutionTime() {
		return avgExecutionTime;
	}

	public void setAvgExecutionTime(String avgExecutionTime) {
		this.avgExecutionTime = avgExecutionTime;
	}

	public String getTotalExecutionTime() {
		return totalExecutionTime;
	}

	public void setTotalExecutionTime(String totalExecutionTime) {
		this.totalExecutionTime = totalExecutionTime;
	}

	public String getMinExecutionTime() {
		return minExecutionTime;
	}

	public void setMinExecutionTime(String minExecutionTime) {
		this.minExecutionTime = minExecutionTime;
	}

	public String getMaxExecutionTime() {
		return maxExecutionTime;
	}

	public void setMaxExecutionTime(String maxExecutionTime) {
		this.maxExecutionTime = maxExecutionTime;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
