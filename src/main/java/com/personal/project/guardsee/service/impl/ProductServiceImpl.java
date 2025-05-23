package com.personal.project.guardsee.service.impl;

import com.personal.project.guardsee.model.Product;
import com.personal.project.guardsee.model.ProductListDTO;
import com.personal.project.guardsee.model.ProductStateDTO;
import com.personal.project.guardsee.model.State;
import com.personal.project.guardsee.repository.ProductRepository;
import com.personal.project.guardsee.service.ProductService;
import jakarta.transaction.Transactional;
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

    @Override
    public List<ProductStateDTO> countProductByName() {
        var listReturned = repository.countProductByName();
        List<ProductStateDTO> productsDistincted = new java.util.ArrayList<>();

        while(!listReturned.isEmpty()) {
            var productToAdd = new ProductStateDTO(listReturned.getFirst().getName());

            while(!listReturned.isEmpty() &&
                    listReturned.getFirst().getName().equalsIgnoreCase(productToAdd.getName())) {
                var firstObject = listReturned.getFirst();
                productToAdd.addState(new State(firstObject.getState(), firstObject.getQuantity()));
                listReturned.removeFirst();
            }
            productsDistincted.add(productToAdd);
        }
        return productsDistincted;
    }
}
