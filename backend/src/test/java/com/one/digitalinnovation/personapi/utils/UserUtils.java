package com.one.digitalinnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.one.digitalinnovation.personapi.dto.UserDTO;
import com.one.digitalinnovation.personapi.entities.User;

public class UserUtils {

	
	private static final String FIRST_NAME = "Thiago";
    private static final String LAST_NAME = "Fonseca";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
    public static UserDTO createFakeDTO() {
        return UserDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phone(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static User createFakeEntity() {
        return User.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phone(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}

	

