package com.poc.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
@CsvRecord(separator = ",")
public class Part implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@XmlElement
	@DataField(pos = 1)
	private int id;
	@XmlElement
	@DataField(pos = 2)
	private String partName;

	@XmlElement
	@DataField(pos = 3)
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
