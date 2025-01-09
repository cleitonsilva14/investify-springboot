package io.com.investify.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.time.Instant;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.com.investify.repository.UserRepository;

import io.com.investify.dto.CreateUserDto;
import io.com.investify.entity.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	// Triple way
	// Arrange -> Act -> Assert
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Nested
	class createUser{
		
		@Test
		@DisplayName("Deve criar um user com sucesso!")
		void shouldCreateAUserWithSuccess() {
			var user = new UserEntity(
				UUID.randomUUID(),
				"username", "email@gmil.com", "password", Instant.now(), null
			);
			
			// 9:20
			
			doReturn(null).when(userRepository).save(any());
			var input = new CreateUserDto(
					"ana.silva", 
					"anasilva12@gmail.com", 
					"1234"
			);
			
			userService.createUser(input);
		
		
			
			
		}
		
	}

}
