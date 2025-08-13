package com.store.inventory.service.controllers;


import com.store.inventory.service.models.Inventory;
import com.store.inventory.service.models.Product;
import com.store.inventory.service.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    InventoryServices inventoryServices;

    @GetMapping
    public ResponseEntity<List<Inventory>>  findAll(){
        List<Inventory>  inventories_list = inventoryServices.findAll();
        return ResponseEntity.ok().body(inventories_list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Inventory> findById(@PathVariable Long id){
        Inventory inventory_by_id = inventoryServices.findById(id);
        return ResponseEntity.ok().body(inventory_by_id);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        for (Product product : inventory.getProducts()) {
            product.setInventory(inventory);
        }
        Inventory savedInventory = inventoryServices.save(inventory);
        return ResponseEntity.ok().body(savedInventory);
    }

}
