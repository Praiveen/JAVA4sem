package com.example.prak22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@EnableScheduling
public class DataUpdateScheduler {
    @Autowired
    private ProductService productService;

    private static final String DIRECTORY_PATH = "C:/MIREA/JAVA/JAVA4sem/prak22/Dir";

//    @Scheduled(cron = "0 */30 * * * *")
    @Scheduled(cron = "0 * * * * *")
    public void updateData() {
        clearDirectory();
        productService.saveDataToFiles();
    }

    private void clearDirectory() {
        try {
            Files.walk(Paths.get(DIRECTORY_PATH))
                    .filter(Files::isRegularFile)
                    .map(java.nio.file.Path::toFile)
                    .forEach(File::delete);
            System.out.println("Directory cleared successfully.");
        } catch (IOException e) {
            System.out.println("Failed to clear directory: " + e.getMessage());
        }
    }
}

