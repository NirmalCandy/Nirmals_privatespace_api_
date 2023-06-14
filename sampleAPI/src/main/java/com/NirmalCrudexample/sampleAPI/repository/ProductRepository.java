package com.NirmalCrudexample.sampleAPI.repository;

import com.NirmalCrudexample.sampleAPI.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}