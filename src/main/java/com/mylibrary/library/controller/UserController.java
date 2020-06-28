package com.mylibrary.library.controller;

import com.mylibrary.library.domain.Token;
import com.mylibrary.library.domain.User;
import com.mylibrary.library.exception.ValueNotFoundException;
import com.mylibrary.library.mapper.UserMapper;
import com.mylibrary.library.repository.TokenRepository;
import com.mylibrary.library.repository.UserRepository;
import com.mylibrary.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    public UserController(UserService userService, UserRepository userRepository, TokenRepository tokenRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        return "hello";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return "sign-up";
    }

    @GetMapping("/token")
    public String token(@RequestParam String value) throws ValueNotFoundException {
        Token byValue = tokenRepository.findByValue(value).orElseThrow(() -> new ValueNotFoundException("Token doesn't exist"));
        User user = byValue.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        return "hello";
    }

}
