package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.User;
import com.epitech.dashboard.repository.UserRepo;
import com.epitech.dashboard.service.ValidatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/connection")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/connection")
    public String login(@RequestParam String name, @RequestParam String password, Model model){
        try {
            ValidatePassword validation = new ValidatePassword();
            for (User user : userRepo.findByName(name)) {
                if (validation.validatePassword(password, user.getPassword())){
                    user.setConnected(true);
                    userRepo.save(user);
                    System.out.println(user.getName());
                    model.addAttribute("user", user);
                    return "home";
                }
                else{
                    user.setConnected(false);
                }
            }
            return "home";
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return "home";
        }
    }
}
