package com.poc.bean;

import java.io.Serializable;

/**
 * 
 * @author amitjaiswal
 *
 */

public class Part implements Serializable {
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

	/**
	 * @param partName
	 * @param quantity
	 * @param id
	 */
	public Part(String partName, int quantity, int id) {
		super();
		this.id = id;
		this.partName = partName;
		this.quantity = quantity;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
