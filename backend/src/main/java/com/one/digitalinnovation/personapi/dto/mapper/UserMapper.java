package com.one.digitalinnovation.personapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.one.digitalinnovation.personapi.dto.UserDTO;
import com.one.digitalinnovation.personapi.entities.User;

@Mapper
public interface UserMapper {

	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	 
	 @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	    
	User toModel(UserDTO userDTO);

	    UserDTO toDTO(User user);
	
}
