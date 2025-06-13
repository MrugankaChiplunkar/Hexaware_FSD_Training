package com.springannot.example.SpringBook;

import java.util.List;

public class Book{
	int code;
	String name;
	double price;
	List <String> cityList;
	String sales;
	
	Book()
	{
		
	}
 
	public int getCode() {
		return code;
	}
 
	public void setCode(int code) {
		this.code = code;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public double getPrice() {
		return price;
	}
 
	public void setPrice(double price) {
		this.price = price;
	}
 
	public List<String> getCityList() {
		return cityList;
	}
 
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
 
	public Book(int code, String name, double price, List<String> cityList , String sales) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.cityList = cityList;
		this.sales=sales;
	}
 
	@Override
	public String toString() {
		return "Book [code=" + code + ", name=" + name + ", price=" + price + ", cityList=" + cityList + ", sales="
				+ sales + "]";
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}	
 
}