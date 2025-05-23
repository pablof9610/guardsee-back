package com.personal.project.guardsee.repository;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//select name, state, count(state) from tb_product group by name;
    @Query("SELECT new com.personal.project.guardsee.model.ProductListDTO(p.name, p.state, COUNT(p.state)) FROM Product p GROUP BY p.name, p.state ORDER BY p.name")
    List<ProductListDTO> countProductByName();

    int deleteBySerialNumber(String serialNumber);
}
