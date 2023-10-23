package com.cyberark.conjur.plugintest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cyberark.conjur.plugintest.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}

