package com.Maven.Hibernate.HibernateOneToOneMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Vehicle {
	
	@Id
	int vehicleId;
	String owner;
	
  @OneToOne(targetEntity =Plate.class )              //for one to one mapping
	
	Plate plate;
	
	Vehicle(){
		
	}

	public Vehicle(int vehicleId, String owner, Plate plate) {
		super();
		this.vehicleId = vehicleId;
		this.owner = owner;
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", owner=" + owner + "]";
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}
	
	

}
