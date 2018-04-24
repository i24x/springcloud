package com.github.i24x.service.model;

import java.io.Serializable;
import java.util.UUID;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	public String labelCn;
	public String cuid;
	public String author;
	public String price;
	public Book() {
		this.setCuid("BOOK-"+UUID.randomUUID().toString().replace("-", ""));
	}
	public String getLabelCn() {
		return labelCn;
	}
	public void setLabelCn(String labelCn) {
		this.labelCn = labelCn;
	}
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [labelCn=" + labelCn + ", cuid=" + cuid + ", author=" + author + ", price=" + price + "]";
	}
	
}
