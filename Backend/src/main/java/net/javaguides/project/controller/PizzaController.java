package net.javaguides.project.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.project.repository.PizzaRepository;
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
import net.javaguides.project.model.Pizza;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;
    // get all employees
    @GetMapping("/menu-items")
    public List<Pizza> getAllMenuItems(){
        return pizzaRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/menu-items")
    public Pizza createMenuItem(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    // get employee by id rest api
    @GetMapping("/menu-items/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item not exist with id :" + id));
        return ResponseEntity.ok(pizza);
    }

    // update employee rest api
    @PutMapping("/menu-items/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza pizzaDetails){
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item does not exist with id :" + id));
        pizza.setItemName(pizzaDetails.getItemName());
        pizza.setDescription(pizzaDetails.getDescription());
        pizza.setPrice(pizzaDetails.getPrice());
        pizza.setUrl(pizzaDetails.getUrl());
        Pizza updatedPizza = pizzaRepository.save(pizza);
        return ResponseEntity.ok(updatedPizza);
    }

    // delete employee rest api
    @DeleteMapping("/menu-items/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePizza(@PathVariable Long id){
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item does not exist with id :" + id));
        pizzaRepository.delete(pizza);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}