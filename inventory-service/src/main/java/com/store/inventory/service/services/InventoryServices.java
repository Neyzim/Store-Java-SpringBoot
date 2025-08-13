package com.store.inventory.service.services;

import com.store.inventory.service.models.Inventory;
import com.store.inventory.service.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServices {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    public List<Inventory> findAll(){
        return inventoryRepository.findAll();
    }

    public Inventory findById(Long id){
        Optional<Inventory> Inventory_list = inventoryRepository.findById(id);
        return Inventory_list.get();
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
