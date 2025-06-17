package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/saveData")
    public Customer saveData(@RequestBody Customer c) {
        return service.saveCustomer(c);
    }

    @GetMapping("/getUsers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/getdataAc/{ac}")
    public Customer getCustomerByAccNo(@PathVariable int ac) {
        return service.getCustomerByAccNo(ac);
    }

    @DeleteMapping("/deleteByAc/{ac}")
    public String deleteCustomer(@PathVariable int ac) {
        return service.deleteCustomerByAccNo(ac);
    }

    @PutMapping("/deposit/{accno}/{amount}")
    public String depositAmount(@PathVariable int accno, @PathVariable double amount) {
        return service.depositToAccount(accno, amount);
    }
    
    @GetMapping("/getByName/{name}")
    public Customer getByName(@PathVariable String name) {
        return service.getCustomerByName(name);
    }
    
    @PutMapping("/depositQuery/{accno}/{amount}")
    public String depositUsingQuery(@PathVariable int accno, @PathVariable double amount) {
        return service.depositUsingJPQL(accno, amount);
    }
    
    @PutMapping("/withdraw/{accno}/{amount}")
    public String withdraw(@PathVariable int accno, @PathVariable double amount) {
        return service.withdrawAmount(accno, amount);
    }
    
    @DeleteMapping("/getDelete/{ac}")
    public String getDelete(@PathVariable int ac) {
        return service.deleteById(ac);
    }


}
