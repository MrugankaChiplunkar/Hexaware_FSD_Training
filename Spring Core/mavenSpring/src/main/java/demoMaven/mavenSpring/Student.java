package demoMaven.mavenSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
    private int rollno = 1;
    private String name = "Ajay";
    private double fee = 5000;

    @Autowired
    @Qualifier("home")
    private Address a1;

    public Student() {
        System.out.println("Student constructor called.");
    }

    // Getters and setters
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Address getA1() {
        return a1;
    }

    public void setA1(Address a1) {
        this.a1 = a1;
    }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", fee=" + fee + ", a1=" + a1 + "]";
    }
}
