package com.personal.project.guardsee.service;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductStateDTO;

import java.util.List;

public interface ProductService {
//    Product getProductByID(Long id);
    List<ProductStateDTO> countProductByName();
    List<Product> getAllProduct();
    Long saveProduct(Product product);
    Long deleteProductBySerialNumber(String serialNumber);
//    Long updateProduct(Product product);
}
