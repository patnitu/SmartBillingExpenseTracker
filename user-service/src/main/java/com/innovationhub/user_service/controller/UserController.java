package com.innovationhub.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovationhub.user_service.dto.UserRequest;
import com.innovationhub.user_service.entity.User;
import com.innovationhub.user_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	 @PostMapping("/register")
	 public ResponseEntity<User> register(@Valid @RequestBody UserRequest request) {
	     return ResponseEntity.ok(userService.register(request));
	 }
	 
	 @GetMapping("/email/{email}")
	 public ResponseEntity<User> getByEmail(@PathVariable String email) {
	     return userService.findByEmail(email)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	 }
}
