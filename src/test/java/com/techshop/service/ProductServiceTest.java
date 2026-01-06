package com.techshop.service;

import com.techshop.model.Product;
import com.techshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testSaveProduct_Success() {
        // Arrange
        Product product = new Product();
        product.setName("New Product");
        product.setPrice(BigDecimal.TEN);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        Product result = productService.saveProduct(product);

        // Assert
        assertNotNull(result);
        assertEquals("New Product", result.getName());
    }

    @Test
    public void testGetProductById_Success() {
        // Arrange
        Product product = new Product();
        product.setId(1L);
        product.setName("Existing Product");

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Act
        Product result = productService.getProductById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
}
