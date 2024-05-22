package com.RESTFull.Api.service;

import com.RESTFull.Api.entity.Product;
import com.RESTFull.Api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getALLProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product saveProduct (Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
