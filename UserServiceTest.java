package com.techshop.service;

import com.techshop.dto.RegisterRequest;
import com.techshop.model.Role;
import com.techshop.model.User;
import com.techshop.repository.CartRepository;
import com.techshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegister_Success() {
        // Arrange
        RegisterRequest request = new RegisterRequest();
        request.setUsername("testuser");
        request.setPassword("password");
        request.setEmail("test@example.com");

        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        
        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername("testuser");
        savedUser.setRole(Role.REGISTERED_USER);
        
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        User result = userService.register(request);

        // Assert
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(cartRepository, times(1)).save(any()); // Verify cart creation
    }

    @Test
    public void testRegister_UsernameTaken() {
        // Arrange
        RegisterRequest request = new RegisterRequest();
        request.setUsername("existing");

        when(userRepository.existsByUsername("existing")).thenReturn(true);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.register(request));
    }
}
