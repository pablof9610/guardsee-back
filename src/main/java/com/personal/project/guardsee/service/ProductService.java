package com.personal.project.guardsee.service;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductStateDTO;

import java.util.List;

public interface ProductService {
    List<ProductStateDTO> countProductByName();
    List<Product> findAllProduct();
    Long saveProduct(Product product);
    Long deleteProductBySerialNumber(String serialNumber);
//    Long updateProduct(Product product);
}
