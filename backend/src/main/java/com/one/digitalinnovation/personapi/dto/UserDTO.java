package com.one.digitalinnovation.personapi.dto;


import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 2, max =100)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max =100)
	private String lastName;

	@NotEmpty
	@CPF
	private String cpf;

	//@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
	@NotNull
	private String birthDate;

	@Valid
	//@NotEmpty
	private List<PhoneDTO> phone;

}
