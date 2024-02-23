package com.concurrent.ecommerce.service;

import com.concurrent.ecommerce.config.repository.ProductRepository;
import com.concurrent.ecommerce.model.dto.ProductDTO;
import com.concurrent.ecommerce.model.entity.ProductEntity;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public ProductEntity updateQuantityInStock(Long id, Long newQuantity) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setQuantityInStock(newQuantity);
        return productRepository.save(product);
    }

    @Transactional
    public ProductEntity updatePrice(Long id, double newPrice) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setPrice(newPrice);
        return productRepository.save(product);
    }

    public ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity product = modelMapper.map(productDTO,ProductEntity.class);
        return productRepository.save(product);
    }

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id){
        return productRepository.findById(id);
    }


}
