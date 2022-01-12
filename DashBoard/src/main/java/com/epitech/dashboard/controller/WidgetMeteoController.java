package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.model.WidgetMeteo;
import com.epitech.dashboard.service.WidgetMeteoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WidgetMeteoController {
    @PostMapping("/createMeteoWidget")
    public String createMeteoWidget(@RequestParam String src, Model model , HttpServletRequest request){
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;

        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        WidgetMeteoService widgetMeteoService = new WidgetMeteoService();
        WidgetMeteo WidgetMeteoA =  widgetMeteoService.createWidgetMeteo(src);
        widgetList.add(WidgetMeteoA);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        return "redirect:/";
    }
}
