package com.one.digitalinnovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.digitalinnovation.personapi.entities.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long>{

}
