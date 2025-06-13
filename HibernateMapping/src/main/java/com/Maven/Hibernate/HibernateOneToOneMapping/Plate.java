package com.Maven.Hibernate.HibernateOneToOneMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plate {
	
	@Id
	String plateNo;

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	@Override
	public String toString() {
		return "Plate [plateNo=" + plateNo + "]";
	}

	public Plate(String plateNo) {
		super();
		this.plateNo = plateNo;
	}

	public Plate() {
		// TODO Auto-generated constructor stub
	}
	
	
}
