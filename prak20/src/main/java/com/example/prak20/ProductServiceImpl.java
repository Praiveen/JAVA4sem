package com.example.prak20;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;
    public List<Product> getProducts() {
        log.info("Find all users");
        return productRepository.findAll();
    }
    public void saveOrUpdate(Product user){
        log.info("Save user {}", user);
        productRepository.save(user);
    }
}

