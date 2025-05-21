package com.personal.project.guardsee.repository;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.personal.project.guardsee.model.ProductListDTO(p.name, COUNT(p)) FROM Product p GROUP BY p.name")
    List<ProductListDTO> countProductByName();
}
