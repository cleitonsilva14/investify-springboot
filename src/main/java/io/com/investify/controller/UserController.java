package io.com.investify.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.com.investify.dto.CreateUserDto;
import io.com.investify.entity.UserEntity;
import io.com.investify.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody CreateUserDto createUserDto){
		var userId = userService.createUser(createUserDto);
		return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable String userId){
		var user = userService.getUserById(userId);
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user.get());
	}
	
	
	
}
