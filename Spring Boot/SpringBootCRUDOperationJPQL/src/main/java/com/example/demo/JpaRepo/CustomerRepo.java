package com.example.demo.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query(value="select * from Customer", nativeQuery=true)  
    List<Customer> findAllCustomer();
    
    @Query(value="select * from Customer c where c.name=:name", nativeQuery=true)
	public Customer findByName(@Param("name") String name);
 
	@Transactional
	@Modifying
	@Query(value="update Customer  c set c.balance=c.balance+ :amt  where c.accno=:accno", nativeQuery=true)
public int deposit1(@Param("accno") int accno, @Param("amt")double amt);
	
	@Transactional
	@Modifying
	@Query(value="update Customer c set c.balance = c.balance - :amt where c.accno = :accno", nativeQuery=true)
	int withdraw(@Param("accno") int accno, @Param("amt") double amt);

	
	//@Query("delete from Customer c where c.accno = :accno") ----- without native query
	@Modifying
	@Transactional
	@Query(value="delete from Customer c where c.accno = :accno", nativeQuery=true)
	public int deleteCust(@Param("accno") int accno);

	// Use this to find if the account exists before deletion
	@Query(value="select * from Customer c where c.accno = :accno", nativeQuery=true)
	public Customer findByActJPQL(@Param("acco") int accno);

}
