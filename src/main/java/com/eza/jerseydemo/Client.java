package com.eza.jerseydemo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {

	private int id;
	private String name;
/*	private double amount;
	private String street;*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}*/
	public Client(int id, String name/*, double amount, String street*/) {
		super();
		this.id = id;
		this.name = name;
/*		this.amount = amount;
		this.street = street;*/
	}
	
	public Client() {}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
	
	

}
