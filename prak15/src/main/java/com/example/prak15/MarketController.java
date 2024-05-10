package com.example.prak15;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarketRepository marketRepository;

    @PostMapping("/product")
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PostMapping("/market")
    public void createMarket(@RequestBody Market market) {
        marketRepository.save(market);
    }

    @GetMapping("/markets")
    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    @DeleteMapping("/market/{id}")
    public void deleteMarket(@PathVariable Long id) {
        marketRepository.deleteById(id);
    }
}

