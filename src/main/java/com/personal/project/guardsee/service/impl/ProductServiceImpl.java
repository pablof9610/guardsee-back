package com.personal.project.guardsee.service.impl;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.repository.ProductRepository;
import com.personal.project.guardsee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Long saveProduct(Product product) {
        return repository.save(product).getId();
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }
}
