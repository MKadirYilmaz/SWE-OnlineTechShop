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


        User result = userService.register(request);


        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(cartRepository, times(1)).save(any()); // Verify cart creation
    }

    @Test
    public void testRegister_UsernameTaken() {

        RegisterRequest request = new RegisterRequest();
        request.setUsername("existing");

        when(userRepository.existsByUsername("existing")).thenReturn(true);

        assertThrows(RuntimeException.class, () -> userService.register(request));
    }

    @Test
    public void testFindByUsername_Success() {

        String username = "testuser";
        User user = new User();
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(java.util.Optional.of(user));

        User result = userService.findByUsername(username);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
    }

    @Test
    public void testFindByUsername_NotFound() {

        String username = "unknown";

        when(userRepository.findByUsername(username)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.findByUsername(username));
    }

    @Test
    public void testChangePassword_Success() {

        String username = "testuser";
        String oldPass = "oldpass";
        String newPass = "newpass";

        User user = new User();
        user.setUsername(username);
        user.setPassword(oldPass);

        when(userRepository.findByUsername(username)).thenReturn(java.util.Optional.of(user));

        userService.changePassword(username, oldPass, newPass);

        assertEquals(newPass, user.getPassword());
        verify(userRepository).save(user);
    }

    @Test
    public void testChangePassword_InvalidOldPassword() {
        String username = "testuser";
        String oldPass = "wrongpass";
        String newPass = "newpass";

        User user = new User();
        user.setUsername(username);
        user.setPassword("correctpass");

        when(userRepository.findByUsername(username)).thenReturn(java.util.Optional.of(user));

        assertThrows(RuntimeException.class, () -> userService.changePassword(username, oldPass, newPass));
    }
}
