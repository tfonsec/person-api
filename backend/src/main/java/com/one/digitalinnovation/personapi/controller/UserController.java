package com.one.digitalinnovation.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.one.digitalinnovation.personapi.dto.UserDTO;
import com.one.digitalinnovation.personapi.dto.response.MessageResponseDTO;

import com.one.digitalinnovation.personapi.service.UserService;
import com.one.digitalinnovation.personapi.service.exception.UserNotFoundException;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	private UserService userService;



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO) {
		return userService.createUser(userDTO);
	}

	@GetMapping
	public List<UserDTO> listAll() {
		return userService.listAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO findById(@PathVariable Long id) throws UserNotFoundException {
		return userService.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws UserNotFoundException {
		userService.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) throws UserNotFoundException {
		return userService.update(id, userDTO);
	}
}
