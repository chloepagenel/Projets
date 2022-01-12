package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.*;
import com.epitech.dashboard.model.gw2account.Gw2Account;
import com.epitech.dashboard.service.Gw2service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.epitech.dashboard.model.Widget;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Gw2WvWController {
    @PostMapping("/createWidgetGW2WvW")
    public String createWidgetGW2WvW(@RequestParam String id,  HttpServletRequest request){
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;

        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        WidgetGW2WvW gw2WvW = new WidgetGW2WvW(id);
        widgetList.add(gw2WvW);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);

        return "redirect:/";
    }

    @PostMapping("/createWidgetGW2account")
    public String createWidgetGWaccount(@RequestParam String UserId,  HttpServletRequest request){
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;

        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        Gw2service gw2service = new Gw2service();
        Gw2Account account = gw2service.getAccountApiCall(UserId);
        WidgetGW2account widgetAccount = gw2service.createWidgetGW2Account(account);
        widgetList.add(widgetAccount);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);

        return "redirect:/";
    }
}
