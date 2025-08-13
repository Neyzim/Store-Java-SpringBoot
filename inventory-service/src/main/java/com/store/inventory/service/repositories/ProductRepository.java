package com.store.inventory.service.repositories;

import com.store.inventory.service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
