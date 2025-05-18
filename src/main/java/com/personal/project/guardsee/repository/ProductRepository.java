package com.personal.project.guardsee.repository;

import com.personal.project.guardsee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
