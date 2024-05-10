package com.example.prak14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketController {

    private List<Product> products = new ArrayList<>();
    private List<Market> markets = new ArrayList<>();

    @PostMapping("/product")
    public void createProduct(@RequestBody Product product) {
        products.add(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @DeleteMapping("/product/{index}")
    public void deleteProduct(@PathVariable int index) {
        products.remove(index);
    }

    @PostMapping("/market")
    public void createMarket(@RequestBody Market market) {
        markets.add(market);
    }

    @GetMapping("/markets")
    public List<Market> getAllMarkets() {
        return markets;
    }

    @DeleteMapping("/market/{index}")
    public void deleteMarket(@PathVariable int index) {
        markets.remove(index);
    }
}

