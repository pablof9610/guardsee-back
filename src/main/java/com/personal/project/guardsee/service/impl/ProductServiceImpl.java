package com.personal.project.guardsee.service.impl;

import com.personal.project.guardsee.exception.DuplicatedProductPropException;
import com.personal.project.guardsee.model.Product;
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
        if (repository.findProductBySerialNumber(product.getSerialNumber()).isPresent())
            throw new DuplicatedProductPropException();
        return repository.save(product).getId();
    }

    @Override
    public List<Product> findAllProduct() {
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

    @Override
    @Transactional
    public Long deleteProductBySerialNumber(String serialNumber) {
        return (long) repository.deleteBySerialNumber(serialNumber);
    }

    @Override
    public Product updateProductBySerialNumber(Product productToUpdate) {
        var productOptional = repository.findProductBySerialNumber(productToUpdate.getSerialNumber());
        if (productOptional.isEmpty()) throw new NoSuchElementException();
        var productFounded = productOptional.get();
        productFounded.setName(productToUpdate.getName());
        productFounded.setState(productToUpdate.getState());
        productFounded.setModel(productToUpdate.getModel());
        productFounded.setTicket(productToUpdate.getTicket());
        productFounded.setVendor(productToUpdate.getVendor());
        productFounded.setSerialNumber(productToUpdate.getSerialNumber());
        productFounded.setDetail(productToUpdate.getDetail());
        repository.save(productFounded);
        return productFounded;
    }
}
