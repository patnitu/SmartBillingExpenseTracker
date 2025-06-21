package com.innovationhub.user_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.innovationhub.user_service.dto.UserRequest;
import com.innovationhub.user_service.entity.User;
import com.innovationhub.user_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	 private final UserRepository userRepository;
	
	 public User register(UserRequest request) {
	        User user = new User();
	        user.setEmail(request.getEmail());
	        user.setName(request.getName());
	        user.setPassword(request.getPassword()); // Password encryption recommended
	        return userRepository.save(user);
	    }

	    public Optional<User> findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
}
