package com.personal.project.guardsee.service;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductListDTO;

import java.util.List;

public interface ProductService {
//    Product getProductByID(Long id);
    List<ProductListDTO> countProductByName();
    List<Product> getAllProduct();
    Long saveProduct(Product product);
//    Long deleteProductByID(Long id);
//    Long updateProduct(Product product);
}
