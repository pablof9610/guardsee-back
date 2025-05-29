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
        return productService.findAllProduct();
    }

    @GetMapping("/distinct")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductStateDTO> getAllProductDistinct() {
        return productService.countProductByName();
    }

    @DeleteMapping(value = "/{serialnumber}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long deleteProductBySerialNumber(@PathVariable(value = "serialnumber") String serialNumber) {
        return productService.deleteProductBySerialNumber(serialNumber);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Product> updateProductBySerialNumber(@RequestBody Product productToUpdate) {
        var productUpdated = productService.updateProductBySerialNumber(productToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }
}
