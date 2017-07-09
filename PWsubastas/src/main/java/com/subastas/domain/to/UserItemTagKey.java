package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class UserItemTagKey implements Serializable {
	private BigDecimal usuarioId;
	private BigDecimal itemId;
	private BigDecimal tagId;
	public UserItemTagKey(){
		
	}
	public UserItemTagKey(BigDecimal usuarioId, BigDecimal itemId,
			BigDecimal tagId) {
		super();
		this.usuarioId = usuarioId;
		this.itemId = itemId;
		this.tagId = tagId;
	}
	
}
