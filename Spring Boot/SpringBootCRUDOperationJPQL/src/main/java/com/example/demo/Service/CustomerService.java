package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Customer;
import com.example.demo.JpaRepo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo repo;

    public Customer saveCustomer(Customer c) {
        return repo.save(c);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAllCustomer();
    }

    public Customer getCustomerByAccNo(int ac) {
        return repo.findById(ac).orElse(null);
    }

    public String deleteCustomerByAccNo(int ac) {
        Customer c = repo.findById(ac).orElse(null);
        if (c != null) {
            repo.deleteById(ac);
            return "Customer deleted successfully.";
        } else {
            return "Customer not found.";
        }
    }

    public String depositToAccount(int accno, double amount) {
        Customer c = repo.findById(accno).orElse(null);
        if (c != null) {
            c.setBalance(c.getBalance() + amount);
            repo.save(c);
            return "Amount deposited successfully.";
        } else {
            return "Account not found.";
        }
    }
    
    public Customer getCustomerByName(String name) {
        return repo.findByName(name);
    }
    
    @Transactional
    public String depositUsingJPQL(int accno, double amt) {
        int x = repo.deposit1(accno, amt);
        if (x > 0) {
            return "updated";
        } else {
            return "not updated";
        }
    }
   

    public String withdrawAmount(int accno, double amt) {
        Customer c = repo.findById(accno).orElse(null);

        if (c != null) {
            double currbal = c.getBalance();

            if (currbal >= 1000 && currbal >= amt) {
                repo.withdraw(accno, amt);
                return "amount withdrawn ";
            } else {
                return "insufficient balance";
            }
        } else {
            return "acc not found.";
        }
    }
    

    public String deleteById(int ac) {
        Customer c = repo.findByActJPQL(ac);
        if (c != null) {
            int r = repo.deleteCust(ac);
            if (r > 0) {
                return "Deletion successful";
            }
            return "Error while deleting";
        }
        return "No such customer";
    }


}
