package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.Widget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RemoveWidgetController {

    @PostMapping("/widget/{id}")
    public String DeleteWidget(@PathVariable long id , HttpSession session , HttpServletRequest request){
        List<Widget> widgetList= (List<Widget>) session.getAttribute("WIDGETS_SESSION");
        if ( widgetList != null ) {
            for(int i = 0 ; i < widgetList.size();i++ ){
                if( widgetList.get(i).getId() == id){
                    widgetList.remove(i);
                }
            }
        }else {
            widgetList = new ArrayList<>();
        }
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        return "redirect:/";
    }

    @PostMapping("/deleteAllWidgets")
    public String DeleteAllWidgets( HttpSession session , HttpServletRequest request){
        List<Widget> widgetList= (List<Widget>) session.getAttribute("WIDGETS_SESSION");

        if ( widgetList != null ) {
            widgetList.clear();
        }else {
            widgetList = new ArrayList<>();
        }
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        return "redirect:/";
    }
}
