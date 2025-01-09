package io.com.investify.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.com.investify.dto.CreateUserDto;
import io.com.investify.entity.UserEntity;
import io.com.investify.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UUID createUser(CreateUserDto createUserDto) {
		
		// de-para -> dto para entity
		var userEntity = new UserEntity(
				UUID.randomUUID(),
				createUserDto.username(),
				createUserDto.password(),
				createUserDto.email(),
				Instant.now(),
				null
		);
		
		var user = userRepository.save(userEntity);
		
		return user.getUserId();
	}
	
	public Optional<UserEntity> getUserById(String userId) {
		return userRepository.findById(UUID.fromString(userId));
	}
	
	public List<UserEntity> getUserList(){
		return userRepository.findAll();
	}
	
	
	
}
