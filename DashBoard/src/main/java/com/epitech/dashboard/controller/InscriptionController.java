package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.User;
import com.epitech.dashboard.repository.UserRepo;
import com.epitech.dashboard.service.EncryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class InscriptionController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/inscription")
    public String inscription(Model model){
        model.addAttribute("user", new User());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        String encryptedpassword = new EncryptPassword().generateStringPasswordHash(password);
        newUser.setPassword(encryptedpassword);
        userRepo.save(newUser);
        model.addAttribute("user",newUser);
        return "login";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepo.findAll();
    }
}
