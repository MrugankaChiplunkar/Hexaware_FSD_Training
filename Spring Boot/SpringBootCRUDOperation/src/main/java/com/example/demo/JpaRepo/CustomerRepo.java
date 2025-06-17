package com.example.demo.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.example.demo.Entity.Customer;
 
 
 
// crud    jpa   
@Repository
public interface CustomerRepo  extends  JpaRepository<Customer, Integer> {
	

 
}
