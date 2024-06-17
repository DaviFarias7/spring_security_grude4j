package com.security.grude4j.repositories;

import com.security.grude4j.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, String> {
}

