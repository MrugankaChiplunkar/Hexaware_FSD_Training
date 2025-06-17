package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemService;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @PostMapping("/addItem")
    public Item saveItem(@RequestBody Item item) {
        Item savedItem = service.addItem(item);
        System.out.println("item added");
        return savedItem;
    }

    @GetMapping("/getItem/{code}")
    public Item getItem(@PathVariable String code) {
        return service.getItemByCode(code);
    }

    @PutMapping("/updatePrice/{code}/{price}")
    public String updatePrice(@PathVariable String code, @PathVariable BigDecimal price) {
        return service.updateItemPrice(code, price);
    }

    @GetMapping("/generateBill/{code}/{quantity}")
    public String generateBill(@PathVariable String code, @PathVariable int quantity) {
        return service.generateBill(code, quantity);
    }
    
    
    
}
