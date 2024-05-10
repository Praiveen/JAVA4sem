package com.example.prak17;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MarketController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarketRepository marketRepository;
    @Autowired
    private MarketService marketService;

    @GetMapping("/market/search/{name}")
    public List<Market> getSpecificSubject(@PathVariable String name) {
        return marketService.getSpecificSubject(name);
    }
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


    @GetMapping("/markets/{id}")
    public ResponseEntity<Market> getMarketById(@PathVariable Long id) {
        Market market = marketService.getMarketById(id);
        return ResponseEntity.ok(market);
    }

}

