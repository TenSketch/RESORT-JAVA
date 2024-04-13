package com.vanavihari.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String emaill);

	public User findByVerificationCode(String code);

	public User findByEmailAndPassword(String email, String password);
	
}
