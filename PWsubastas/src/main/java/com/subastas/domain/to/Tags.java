package com.subastas.domain.to;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Tags")
@NamedQueries({@NamedQuery(name="Tags.findBytagText", query="SELECT t FROM Tags t WHERE t.tagText = ?1"),
@NamedQuery(name="Tags.findByProductoId", query="Select t from UserItemTag uit, Tags t where uit.tagId = t.tagId and uit.itemId = ?1")})
public class Tags implements Serializable {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private BigDecimal tagId;
	@Column(name = "tag_text")
	private String tagText;
	@Column(name = "stemmed_text")
	private String stemmedText;
	@Transient
	private BigDecimal productoId;
	@Transient
	private String urlItem;
	public BigDecimal getTagId() {
		return tagId;
	}
	public void setTagId(BigDecimal tagId) {
		this.tagId = tagId;
	}
	public String getTagText() {
		return tagText;
	}
	public void setTagText(String tagText) {
		this.tagText = tagText;
	}
	public String getStemmedText() {
		return stemmedText;
	}
	public void setStemmedText(String stemmedText) {
		this.stemmedText = stemmedText;
	}
	public BigDecimal getProductoId() {
		return productoId;
	}
	public void setProductoId(BigDecimal productoId) {
		this.productoId = productoId;
	}
	public String getUrlItem() {
		return urlItem;
	}
	public void setUrlItem(String urlItem) {
		this.urlItem = urlItem;
	}
}
