package com.one.digitalinnovation.personapi.service;



import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.one.digitalinnovation.personapi.dto.UserDTO;
import com.one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.personapi.entities.User;
import com.one.digitalinnovation.personapi.repository.UserRespository;
import com.one.digitalinnovation.personapi.utils.UserUtils;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRespository userRepository;
	
	@InjectMocks
	private UserService userService;

	@Test
	void testGivenUserDTOThenReturnSuccessSavedMessage() {
		
		UserDTO userDTO = UserUtils.createFakeDTO();
		User expectedSavedUser = UserUtils.createFakeEntity();
		
        Mockito.when(userRepository.save(any(User.class))).thenReturn(expectedSavedUser);
        
        MessageResponseDTO expectedSuccessMessage = createdExpectedMessageResponse(expectedSavedUser.getId());
        
        MessageResponseDTO successMessage =  userService.createUser(userDTO);
        
        Assertions.assertEquals(expectedSuccessMessage, successMessage);
        
	}

	private MessageResponseDTO createdExpectedMessageResponse(Long   savedUserId) {
		return MessageResponseDTO
        		.builder()
        		.message("Created user with Id" + savedUserId)
        		.build();
	
	}

	
}