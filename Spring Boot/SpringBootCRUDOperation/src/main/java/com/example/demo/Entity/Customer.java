package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

	public Customer(int accno, String name, double balance, String type) {
		super();
		this.accno = accno;
		this.name = name;
		this.balance = balance;
		this.type = type;
	}
	public Customer() {
		super();
	}
	@Id
	int accno;
	String name;
	double balance;
	String type;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Customer [accno=" + accno + ", name=" + name + ", balance=" + balance + ", type=" + type + "]";
	}
	
	
}
