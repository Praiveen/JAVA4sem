package com.example.prak20;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    public List<Product> getAllProducts() {
        log.info("log:getAllProducts");
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        log.info("log:createProduct");
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("log:deleteProduct");
        productRepository.deleteById(id);
    }
}

