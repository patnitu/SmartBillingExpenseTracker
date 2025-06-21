package com.innovationhub.user_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.innovationhub.user_service.dto.UserRequest;
import com.innovationhub.user_service.entity.User;
import com.innovationhub.user_service.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testRegisterUser() {
        UserRequest request = new UserRequest("test@example.com", "Test", "1234");
        User mockUser = new User(1L, "test@example.com", "Test", "1234");

        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        User savedUser = userService.register(request);

        assertEquals("test@example.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }
}
