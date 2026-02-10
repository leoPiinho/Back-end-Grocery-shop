package com.example.myGrocery.service;

import com.example.myGrocery.dao.ItemRepository;
import com.example.myGrocery.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository theItemRepository){
        itemRepository = theItemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(int theId) {
        Optional<Item> result = itemRepository.findById(theId);

        Item theItem = null;
        if (result.isPresent()) {
            theItem = result.get();
        }
        else {
            throw new RuntimeException("Id do item nao encontrado - " + theId);
        }

        return theItem;
    }

    @Transactional
    @Override
    public Item save(Item theItem) {
        return itemRepository.save(theItem);
    }


    @Transactional
    @Override
    public void deleteById(int theId) {
        itemRepository.deleteById(theId);
    }
}
