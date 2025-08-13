package com.store.inventory.service.repositories;

import com.store.inventory.service.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}