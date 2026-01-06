package com.techshop.config;

import com.techshop.model.Category;
import com.techshop.model.Product;
import com.techshop.model.Role;
import com.techshop.model.User;
import com.techshop.repository.CategoryRepository;
import com.techshop.repository.ProductRepository;
import com.techshop.repository.UserRepository;
import com.techshop.service.UserService;
import com.techshop.dto.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository, 
                                   ProductRepository productRepository, 
                                   UserService userService,
                                   UserRepository userRepository) {
        return args -> {
            // Create Categories
            // Create Categories
            Category electronics = categoryRepository.findByName("Electronics");
            if (electronics == null) {
                electronics = new Category();
                electronics.setName("Electronics");
                electronics.setDescription("Gadgets and devices");
                categoryRepository.save(electronics);
            }

            Category books = categoryRepository.findByName("Books");
            if (books == null) {
                books = new Category();
                books.setName("Books");
                books.setDescription("Readings");
                categoryRepository.save(books);
            }

            // Create Products
            if (productRepository.findByName("Smartphone X") == null) {
                Product p1 = new Product();
                p1.setName("Smartphone X");
                p1.setDescription("Latest model smartphone");
                p1.setPrice(new BigDecimal("999.99"));
                p1.setStockQuantity(50);
                p1.setCategory(electronics);
                productRepository.save(p1);
            }

            if (productRepository.findByName("Laptop Pro") == null) {
                Product p2 = new Product();
                p2.setName("Laptop Pro");
                p2.setDescription("High performance laptop");
                p2.setPrice(new BigDecimal("1499.99"));
                p2.setStockQuantity(20);
                p2.setCategory(electronics);
                productRepository.save(p2);
            }

            if (productRepository.findByName("Clean Code") == null) {
                Product p3 = new Product();
                p3.setName("Clean Code");
                p3.setDescription("A Handbook of Agile Software Craftsmanship");
                p3.setPrice(new BigDecimal("30.00"));
                p3.setStockQuantity(100);
                p3.setCategory(books);
                productRepository.save(p3);
            }

            // Create Demo User
            try {
                if (!userRepository.existsByUsername("user")) {
                    RegisterRequest userReq = new RegisterRequest();
                    userReq.setUsername("user");
                    userReq.setPassword("password");
                    userReq.setFirstName("John");
                    userReq.setLastName("Doe");
                    userReq.setEmail("john@example.com");
                    userReq.setAddress("123 Main St");
                    userService.register(userReq);
                    System.out.println("Demo user created: user / password");
                }
            } catch (Exception e) {}

            // Create Admin User
            try {
                if (!userRepository.existsByUsername("admin")) {
                    User admin = new User();
                    admin.setUsername("admin");
                    admin.setPassword("admin"); // Plain text
                    admin.setFirstName("Super");
                    admin.setLastName("Admin");
                    admin.setEmail("admin@techshop.com");
                    admin.setAddress("Admin HQ");
                    admin.setRole(Role.ADMIN);
                    userRepository.save(admin);
                    System.out.println("Demo admin created: admin / admin");
                }
            } catch (Exception e) {}
        };
    }
}
