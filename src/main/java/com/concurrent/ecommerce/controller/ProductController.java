package com.concurrent.ecommerce.controller;

import com.concurrent.ecommerce.model.dto.ProductDTO;
import com.concurrent.ecommerce.model.entity.ProductEntity;
import com.concurrent.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductDTO productDTO) {
        ProductEntity product = productService.createProduct(productDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> listProduct() {
        List<ProductEntity> listProduct = productService.findAll();
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<ProductEntity>> findById(@PathVariable Long id) {
        Optional<ProductEntity> byId = productService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PutMapping("/updatePrice/{id}/{price}")
    public ResponseEntity<ProductEntity> update(@PathVariable Long id, @PathVariable Long price) {
        ProductEntity byId = productService.updatePrice(id, price);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

}
