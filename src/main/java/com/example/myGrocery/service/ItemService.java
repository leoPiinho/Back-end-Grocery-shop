package com.example.myGrocery.service;

import com.example.myGrocery.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    Item findById(int theId);

    Item save(Item theItem);

    void deleteById(int theId);
}
