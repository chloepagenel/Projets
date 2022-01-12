package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.Steam.SteamWidget;
import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.service.SteamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SteamController {
    @PostMapping("/getPlayerSummary")
    public String getPlayerSummary(@RequestParam String steamId, Model model , HttpServletRequest request){

        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;
        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        SteamService steamService = new SteamService();
        SteamWidget steamWidget = steamService.getPlayerSummary(steamId);

        // model.addAttribute("steamName", steamWidget.getSteamName());
        //model.addAttribute("profileUrl", steamWidget.getProfileUrl());
        //model.addAttribute("lastLogOff", steamWidget.getLastLogOut());
        //model.addAttribute("timeCreated", steamWidget.getTimeElapsed());
        widgetList.add(steamWidget);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);

        return "redirect:/";
    }

    @PostMapping("/getOwnedGames")
    public String getOwnedGames(@RequestParam String steamId, int nbr, Model model , HttpServletRequest request){
        SteamService steamService = new SteamService();
        SteamWidget steamWidget = steamService.getOwnedGames(steamId, nbr);
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;
        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        widgetList.add(steamWidget);
        //model.addAttribute("games", steamWidget.getGameList());
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);

        return "redirect:/";
    }
}
