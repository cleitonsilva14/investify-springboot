package io.com.investify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.com.investify.dto.CreateUserDto;
import io.com.investify.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(CreateUserDto createUserDto) {
		// de-para -> dto para entity
		
		userRepository.save();
	}
	
}
