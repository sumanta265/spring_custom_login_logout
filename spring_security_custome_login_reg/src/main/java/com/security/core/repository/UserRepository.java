package com.security.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.core.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {
	UserEntity findByEmailOrUserName(String email, String username);
}
