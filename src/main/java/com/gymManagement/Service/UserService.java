package com.gymManagement.Service;

import org.springframework.http.ResponseEntity;

import com.gymManagement.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	ResponseEntity<?> saveUser(User user);

    ResponseEntity<?> confirmEmail(String confirmationToken);
}
