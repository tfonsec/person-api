package com.one.digitalinnovation.personapi.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.digitalinnovation.personapi.dto.UserDTO;
import com.one.digitalinnovation.personapi.dto.mapper.UserMapper;
import com.one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.personapi.entities.User;
import com.one.digitalinnovation.personapi.repository.UserRespository;
import com.one.digitalinnovation.personapi.service.exception.UserNotFoundException;

@Service
public class UserService {

	private UserRespository userRepository;

	private final UserMapper userMapper = UserMapper.INSTANCE;

	@Autowired
	public UserService(UserRespository userRepository) {
		this.userRepository = userRepository;
	}

	public MessageResponseDTO createUser(UserDTO userDTO) {
		User usertoSave = userMapper.toModel(userDTO);

		User savedUser = userRepository.save(usertoSave);
		return createdMessageResponse(savedUser.getId(), "Created user with Id");

	}

	public List<UserDTO> listAll() {
		List<User> allUser = userRepository.findAll();
		return allUser.stream().map(userMapper::toDTO).collect(Collectors.toList());

	}

	public UserDTO findById(Long id) throws UserNotFoundException {
		User user = verifyIfExists(id);
		return userMapper.toDTO(user);
	}

	public void delete(Long id) throws UserNotFoundException {
		verifyIfExists(id);
		userRepository.deleteById(id);
	}

	public MessageResponseDTO update(Long id, @Valid UserDTO userDTO) throws UserNotFoundException {
		verifyIfExists(id);

		User usertoUpdate = userMapper.toModel(userDTO);
		User updateUser = userRepository.save(usertoUpdate);
		return createdMessageResponse(updateUser.getId(), "Update user with Id");

	}

	private User verifyIfExists(Long id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	private MessageResponseDTO createdMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}

}
