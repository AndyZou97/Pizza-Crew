package net.javaguides.project.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.project.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.project.exception.ResourceNotFoundException;
import net.javaguides.project.model.Item;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    // get all employees
    @GetMapping("/menu-items")
    public List<Item> getAllMenuItems(){
        return itemRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/menu-items")
    public Item createMenuItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    // get employee by id rest api
    @GetMapping("/menu-items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item not exist with id :" + id));
        return ResponseEntity.ok(item);
    }

    // update employee rest api
    @PutMapping("/menu-items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item does not exist with id :" + id));
        item.setItemName(itemDetails.getItemName());
        item.setDescription(itemDetails.getDescription());
        item.setPrice(itemDetails.getPrice());
        item.setUrl(itemDetails.getUrl());
        Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }

    // delete employee rest api
    @DeleteMapping("/menu-items/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item does not exist with id :" + id));
        itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}