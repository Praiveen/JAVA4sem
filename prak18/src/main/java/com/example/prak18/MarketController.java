package com.example.prak18;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    @Autowired
    private MarketService marketService;


    @GetMapping("/search/{name}")
    public List<Market> getSpecificSubject(@PathVariable String name) {
        return marketService.getSpecificSubject(name);
    }

    @GetMapping
    public List<Market> getAllMarkets() {
        return marketService.getAllMarkets();
    }

    @PostMapping
    public Market createMarket(@RequestBody Market market) {
        return marketService.createMarket(market);
    }

    @DeleteMapping("/{id}")
    public void deleteMarket(@PathVariable Long id) {
        marketService.deleteMarket(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Market> getMarketById(@PathVariable Long id) {
        Market market = marketService.getMarketById(id);
        return ResponseEntity.ok(market);
    }
}

