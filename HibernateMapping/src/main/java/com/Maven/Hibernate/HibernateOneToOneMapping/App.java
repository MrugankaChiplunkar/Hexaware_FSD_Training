package com.Maven.Hibernate.HibernateOneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory= new Configuration().
    			   configure("hiber.config.xml").
    			   addAnnotatedClass(Student.class).
    			   addAnnotatedClass(Address.class).
    			   buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	Transaction txt = session.beginTransaction();
    	
//    	Address a1 = new Address();
//    	a1.setAddressid(1);
//    	a1.setCity("pune");
//    	
//    	Address a2 = new Address();
//    	a2.setAddressid(2);
//    	a2.setCity("mumbai");
//    	
//    	
//    	Student s1 = new Student();
//    	s1.setRollno(1);
//    	s1.setName("Mru");
//    	s1.setMarks(10);
//    	s1.setAddress(a1);
//    	
//    	Student s2 = new Student();
//    	s2.setRollno(2);
//    	s2.setName("Mruganka");
//    	s2.setMarks(20);
//    	s2.setAddress(a2);
//    	
//    	session.save(a1);
//    	session.save(s1);
//    	session.save(a2);
//    	session.save(a1);
    	
    	Plate p1 = new Plate();
    	p1.setPlateNo("MH 12 AB 1234");
    	
    	Vehicle v1 = new Vehicle();
    	v1.setOwner("Mru");
    	v1.setPlate(p1);
    	v1.setVehicleId(101);
    	
    	
    	session.save(p1);
    	session.save(v1);
    	txt.commit();
    	
    	System.out.println("Hello");
    }
}
