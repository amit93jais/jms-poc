package com.poc.bean;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Part implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String partName;
	private int quantity;

	public Part() {
		super();
	}

	public Part(String partName, int quantity, int id) {
		super();
		this.id = id;
		this.partName = partName;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
