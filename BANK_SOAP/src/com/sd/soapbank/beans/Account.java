package com.sd.soapbank.beans;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String pass;
	private Double balance;
	
	public Account() {}
	
	public Account(int id, String name, String pass, Double balance) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.balance = balance;
	}
	
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", pass=" + pass + ", balance=" + balance + "]";
	}
}
