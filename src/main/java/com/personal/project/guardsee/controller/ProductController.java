package com.personal.project.guardsee.controller;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductListDTO;
import com.personal.project.guardsee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Long saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/distinct")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductStateDTO> getAllProductDistinct() {
        return productService.countProductByName();
    }
}
