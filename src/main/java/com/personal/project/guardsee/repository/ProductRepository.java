package com.personal.project.guardsee.repository;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new com.personal.project.guardsee.model.ProductListDTO(p.name, p.state, COUNT(p.state)) FROM Product p GROUP BY p.name, p.state ORDER BY p.name")
    List<ProductListDTO> countProductByName();

    int deleteBySerialNumber(String serialNumber);

    Optional<Product> findProductBySerialNumber(String serialNumber);
}
