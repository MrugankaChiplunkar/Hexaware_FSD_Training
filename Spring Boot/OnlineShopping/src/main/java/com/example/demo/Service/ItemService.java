package com.example.demo.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Item;
import com.example.demo.JpaRepository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository repo;

    public Item addItem(Item item) {
        return repo.save(item);
    }

    public Item getItemByCode(String code) {
        return repo.findByCodeNative(code);
    }

    
    public String updateItemPrice(String code, BigDecimal price) {
        int updated = repo.updatePrice(code, price.doubleValue());
        if (updated > 0) {
            return "price updated";
        } else {
            return "item not found";
        }
    }
    
//  for generating bill, take item code from user then using find function check if available or not.
//  if not available display item not found. 
//  if available, check if sufficient quantity asked by user is available or not.
//  if quantity is not available display insufficient quantity. 
//  if quantity is available then take gthat and generate bill
    public String generateBill(String code, int quantity) {
        Item i = repo.findByCodeNative(code);

        if (i == null) {
            return "item not found";
        }

        if (i.getQuantity() < quantity) {
            return "insufficient quantity" + i.getQuantity();
        }

//        BigDecimal total = i.getPrice() * quantity;
//        for big decimal * operator doesnt work so:
        BigDecimal total = i.getPrice().multiply(BigDecimal.valueOf(quantity));

        return "total: "+total;
    }


    
    
    

}
