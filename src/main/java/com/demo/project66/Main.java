package com.demo.project66;

import com.demo.project66.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PostService postService) {
        return (args) -> {
            log.info("Seeding data!");
            postService.seedData();
        };
    }

}
