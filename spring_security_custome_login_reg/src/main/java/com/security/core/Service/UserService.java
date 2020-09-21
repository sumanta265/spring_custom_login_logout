package com.security.core.Service;

import com.security.core.Entity.UserEntity;

public interface UserService {
	long saveUser(UserEntity userEntity);

	UserEntity findUserByUsername(String userName);
}
