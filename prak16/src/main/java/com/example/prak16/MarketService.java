package com.example.prak16;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    public Market getMarketById(Long id) {
        return marketRepository.findById(id).orElse(null);
    }
}