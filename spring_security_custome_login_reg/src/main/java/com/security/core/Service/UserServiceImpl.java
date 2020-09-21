package com.security.core.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.core.Entity.UserEntity;
import com.security.core.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	@Override
	public long saveUser(UserEntity userEntity) {
		UserEntity savedEntity = userRepository.save(userEntity);
		return savedEntity.getId();
	}

	@Override
	public UserEntity findUserByUsername(String userName){
		return userRepository.findByEmailOrUserName(userName,userName);
	}
}