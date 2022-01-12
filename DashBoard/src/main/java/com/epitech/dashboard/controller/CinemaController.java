package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.CinemaWidget;
import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.service.CinemaWidgetService;
import com.omertron.omdbapi.OMDBException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CinemaController {

    @PostMapping("/createCinemaWidget")
    public String createCinemaWidget(@RequestParam String film, int year, Model model, HttpServletRequest request) {
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;

        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        CinemaWidgetService cinemaWidgetService = new CinemaWidgetService();
        CinemaWidget cinemaWidget = cinemaWidgetService.createCinemaWidget(film, year);
        widgetList.add(cinemaWidget);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);

        return "redirect:/";
    }

    @PostMapping("/createCinemaWidget2")
    public String createCinemaWidget2(@RequestParam String film, Model model, HttpServletRequest request) {

        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;
        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        CinemaWidgetService cinemaWidgetService = new CinemaWidgetService();
        CinemaWidget cinemaWidget = cinemaWidgetService.createCinemaWidgetList(film);

        if(cinemaWidget.getListTitleYear() == null) {
            String noFound = "No movies found";
            model.addAttribute("noFound", noFound);
        }
        else{
            widgetList.add(cinemaWidget);
            //model.addAttribute("listeTitleYear", cinemaWidget.getListTitleYear());
            request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        }
        return "redirect:/";
    }
}
