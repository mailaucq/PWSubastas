package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@IdClass(UserItemTagKey.class)
@Table(name = "user_item_tag")
@NamedQuery(name="UserItemTag.findByUsuarioId", query="SELECT uit FROM UserItemTag uit WHERE uit.usuarioId = ?1")
public class UserItemTag implements Serializable {
	@Id
	@Column(name = "my_usuario_id")
	private BigDecimal usuarioId;
	@Id
	@Column(name = "item_id")
	private BigDecimal itemId;
	@Id
	@Column(name = "tag_id")
	private BigDecimal tagId;
	@Column(name = "create_date")
	private Date createDate;
	public BigDecimal getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(BigDecimal usuarioId) {
		this.usuarioId = usuarioId;
	}
	public BigDecimal getItemId() {
		return itemId;
	}
	public void setItemId(BigDecimal itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getTagId() {
		return tagId;
	}
	public void setTagId(BigDecimal tagId) {
		this.tagId = tagId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
