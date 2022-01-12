package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.WebToon.WebToonWidget;
import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.service.WebToonWidgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebToonController {

    @PostMapping("/createWebToonWidget")
    public String createWebTooWidget(@RequestParam String title, Model model, HttpServletRequest request) throws IOException {
        WebToonWidgetService webToonWidgetService = new WebToonWidgetService();
        WebToonWidget webToonWidget = webToonWidgetService.createWebToonWidget(title);
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;
        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        model.addAttribute("toonTitle", title);
        widgetList.add(webToonWidget);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        return "redirect:/";
    }
}
