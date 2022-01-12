package com.epitech.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/deconnection")
    public String deconnection(){
        return "home";
    }
}
