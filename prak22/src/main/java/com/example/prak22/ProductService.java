package com.example.prak22;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    @Autowired
    private EmailService emailService;



    @Autowired
    private ProductRepository productRepository;


    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    public List<Product> getAllProducts() {
        log.info("log:getAllProducts");
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        log.info("log:createProduct");
        emailService.sendEmail("test@example.com", "Новый продукт создан", "Продукт " + product.getName() + " был успешно создан.");

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("log:deleteProduct");
        productRepository.deleteById(id);
    }

    public void saveDataToFiles() {
        log.info("log:saveDataToFiles");
        List<Product> products = productRepository.findAll();
        String directoryPath = "C:/MIREA/JAVA/JAVA4sem/prak22/Dir"; // Путь к директории для сохранения файлов
        for (Product product : products) {
            String filename = directoryPath + "/" + product.getId() + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                writer.write("Name: " + product.getName() + "\n");
                writer.write("Price: " + product.getPrice() + "\n");
                // Добавьте дополнительные поля, если это необходимо
                log.info("Product data saved to file: {}", filename);
            } catch (IOException e) {
                log.error("Failed to save product data to file: {}", filename, e);
            }
        }
    }

}

