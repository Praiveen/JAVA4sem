package com.example.prak21;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    @Autowired
    private EmailService customEmailSender;


    @Autowired
    private ProductRepository productRepository;


    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    public List<Product> getAllProducts() {
        log.info("log:getAllProducts");
        return productRepository.findAll();
    }

    public Product createProduct(Product product) throws MessagingException, jakarta.mail.MessagingException {
        log.info("log:createProduct");
        customEmailSender.sendEmail("jjqqk1@gmail.com", "Новый продукт создан", "Продукт " + product.getName() + " был успешно создан.");

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("log:deleteProduct");
        productRepository.deleteById(id);
    }
}

