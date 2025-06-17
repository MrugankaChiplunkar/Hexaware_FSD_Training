package com.example.demo.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    @Query(value = "select * from Item i where i.code = :code", nativeQuery = true)
    Item findByCodeNative(@Param("code") String code);

    @Transactional
    @Modifying
    @Query(value = "update Item i set i.price = :price where i.code = :code", nativeQuery = true)
    int updatePrice(@Param("code") String code, @Param("price") double price);
}
