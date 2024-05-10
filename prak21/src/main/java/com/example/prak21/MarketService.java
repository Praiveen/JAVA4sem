package com.example.prak21;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    public Market createMarket(Market market) {
        return marketRepository.save(market);
    }

    public void deleteMarket(Long id) {
        marketRepository.deleteById(id);
    }

    public Market getMarketById(Long id) {
        return marketRepository.findById(id).orElse(null);
    }

    public List<Market> getSpecificSubject(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Market> criteriaQuery = criteriaBuilder.createQuery(Market.class);
        Root<Market> root = criteriaQuery.from(Market.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
