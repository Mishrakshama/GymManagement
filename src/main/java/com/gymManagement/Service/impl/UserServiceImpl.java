package com.gymManagement.Service.impl;

import com.gymManagement.Entity.ConfirmationToken;
import com.gymManagement.Entity.User;
import com.gymManagement.Service.EmailService;
import com.gymManagement.Service.UserService;
import com.gymManagement.repository.ConfirmationTokenRepository;
import com.gymManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService
{
        @Autowired
        private UserRepository userRepository;

        @Autowired
        ConfirmationTokenRepository confirmationTokenRepository;

        @Autowired
        EmailService emailService;

        @Override
        public ResponseEntity<?> saveUser(User user) {

            if (userRepository.existsByUserEmail(user.getEmail())) {
                return ResponseEntity.badRequest().body("Error: Email is already in use!");
            }

            userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8085/confirm-account?token="+confirmationToken.getConfirmationToken());
            emailService.sendEmail(mailMessage);

            System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());

            return ResponseEntity.ok("Verify email by the link sent on your email address");
        }

        @Override
        public ResponseEntity<?> confirmEmail(String confirmationToken) {
            ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

            if(token != null)
            {
                User user = userRepository.findByUserEmailIgnoreCase(token.getUserEntity().getEmail());
                user.setEnabled(true);
                userRepository.save(user);
                return ResponseEntity.ok("Email verified successfully!");
            }
            return ResponseEntity.badRequest().body("Error: Couldn't verify email");
        }
    }
