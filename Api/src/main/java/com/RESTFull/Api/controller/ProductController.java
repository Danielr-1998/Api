package com.RESTFull.Api.controller;

import com.RESTFull.Api.entity.Product;
import com.RESTFull.Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //Peticion GET de productos
    // Method: getALLProducts
    //
    @GetMapping
    public List<Product> getALLProducts(){
        return productService.getALLProducts();
    }
    //Peticion Create producto
    // Method: getProductById
    // Params: @PathVariable
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    //Peticion GET de productos con Id
    // Method: getProductById
    // Params: @PathVariable
    @GetMapping ("/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable Long id){
        Optional<Product> product= productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //Peticion put de productos con Id
    // Method: updateProduct
    // Params: @PathVariable,Product Details
    @PutMapping("/{id}")
    public ResponseEntity<Product>updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Optional<Product> productOptional = productService.getProductById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productService.saveProduct(product));
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    //Peticion DELETED de productos con Id
    // Method: deleteProduct
    // Params: @PathVariable
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
