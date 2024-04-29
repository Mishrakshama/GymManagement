package com.gymManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymManagement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUserEmailIgnoreCase(String emailId);

	    Boolean existsByUserEmail(String email);
	    User findByVerificationToken(String token);
}
