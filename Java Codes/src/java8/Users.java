package java8;

import java.util.ArrayList;
import java.util.List;

public class Users {
 
	
	int Uid;
	String name;
	int salary;
	Users()
	{
		
	}
	
	public Users(int uid, String name, int salary) {
		super();
		Uid = uid;
		this.name = name;
		this.salary = salary;
	}
 
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [Uid=" + Uid + ", name=" + name + ", salary=" + salary + "]";
	}	
}
 
 