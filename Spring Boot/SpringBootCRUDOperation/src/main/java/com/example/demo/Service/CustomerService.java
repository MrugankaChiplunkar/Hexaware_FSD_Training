package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.Entity.Customer;
import com.example.demo.JpaRepo.CustomerRepo;
 
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo Respo;
	public  Customer dsaveD(Customer c )
	 {
	    Customer  c1=	Respo.save(c);
	    return c1;
		
	 }
	public List<Customer> getData1()
	{
		
		 List l=Respo.findAll();
		
		 return l;
	}
//	//same using jpql
//	public List<Customer> getData1()
//	{
//		
//		 List l=Respo.findAllCustomer();
//		
//		 return l;
//	}
//	
	public Customer getSearch(int ac)
	{
		 return Respo.findById(ac).orElse(null);
		
	}
	
	
//	public Customer getSearch(int accno)
//	{
//		 return Respo.findByActJPQL(accno);
//		
//	}
	
	public String findByAct(int ac) {
	    Customer c = Respo.findById(ac).orElse(null);
	    if (c != null) {
	        Respo.deleteById(ac);
	        return "deleted";
	    } else {
	        return "not found";
	    }
	}
	
	public String depositByAccno(int accno, double amount) {
	    Customer c = Respo.findById(accno).orElse(null);
	    
	    if (c != null) {
	        double updatedBalance = c.getBalance() + amount;
	        c.setBalance(updatedBalance);
	        Respo.save(c);
	        return "deposit";
	    } else {
	        return "acc not found.";
	    }
	}

	}



 

