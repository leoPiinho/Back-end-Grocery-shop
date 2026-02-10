package com.example.myGrocery.rest;

import com.example.myGrocery.dao.ItemRepository;
import com.example.myGrocery.entity.Item;
import com.example.myGrocery.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
public class ItemRestController {

    private ItemService itemService;

    private JsonMapper jsonMapper;

    @Autowired
    public ItemRestController(ItemService theItemService, JsonMapper theJsonMapper) {
        itemService = theItemService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/itens")
    public List<Item> findAll(){return  itemService.findAll();}

    @GetMapping("/itens/{itemId}")
    public Item getItem(@PathVariable int itemId){

        Item theItem = itemService.findById(itemId);

        if (theItem == null) {
            throw new RuntimeException("Item Id nao encontrado - " + itemId);
        }

        return theItem;
    }

    @PostMapping("/itens")
    public Item addItem(@RequestBody Item theItem){

        theItem.setId(0);

        Item dbItem = itemService.save(theItem);

        return dbItem;
    }

    @PatchMapping("/itens/{itemId}")
    public Item updateItem (@PathVariable int itemId,
                            @RequestBody Map<String, Object> patchPayLoad){

        Item tempItem = itemService.findById(itemId);

        if (tempItem == null) {
            throw new RuntimeException("ID ITEM NAO ENCONTRADO - " + itemId);
        }

        if (patchPayLoad.containsKey("id")){
            throw new RuntimeException("Item id nao permetido - " + itemId);
        }

        Item patchedItem = jsonMapper.updateValue(tempItem,patchPayLoad);

        Item dbItem = itemService.save(patchedItem);

        return dbItem;

    }

    @DeleteMapping("/itens/{itemId}")
    public String deleteItem(@PathVariable int itemId){

        Item tempItem = itemService.findById(itemId);

        if (tempItem == null){
            throw new RuntimeException("Employee id ot found - " + itemId);
        }

        itemService.deleteById(itemId);

        return "ID item deletado!! - " + itemId;
    }

}
