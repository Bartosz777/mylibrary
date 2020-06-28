package com.mylibrary.library.service;

import com.mylibrary.library.domain.ROLE;
import com.mylibrary.library.domain.Token;
import com.mylibrary.library.domain.User;
import com.mylibrary.library.repository.TokenRepository;
import com.mylibrary.library.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private MailService mailService;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, TokenRepository tokenRepository, MailService mailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(ROLE.USER);
        userRepository.save(user);
        sendToken(user);
    }

    private void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepository.save(token);
        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(), "Please confirm this email to finish register!", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
