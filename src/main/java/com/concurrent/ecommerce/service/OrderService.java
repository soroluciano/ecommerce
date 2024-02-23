package com.concurrent.ecommerce.service;

import com.concurrent.ecommerce.config.repository.OrderRepository;
import com.concurrent.ecommerce.model.entity.OrderEntity;
import com.concurrent.ecommerce.model.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderEntity createOrder(OrderEntity orderEntity) {
        OrderEntity savedEntity = orderRepository.save(orderEntity);
        updateProductQuantity(savedEntity);
        return savedEntity;
    }

    @Transactional
    public void updateProductQuantity(OrderEntity orderEntity) {
        Map<Long, Long> productsToBeReleasedFromStock = orderEntity.getProductEntityList().stream().collect(Collectors.groupingBy(ProductEntity::getId, Collectors.counting()));
        productsToBeReleasedFromStock.forEach(productService::updateQuantityInStock);
    }
}
