package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.model.WidgetMeteo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        List<Widget> widgets= (List<Widget>) session.getAttribute("WIDGETS_SESSION");
        model.addAttribute("WidgetList", widgets != null?widgets: new ArrayList<>());
        return "home";
    }

}
