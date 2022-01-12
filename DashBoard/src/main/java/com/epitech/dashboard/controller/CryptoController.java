package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.model.WidgetBourse;
import com.epitech.dashboard.model.WidgetConversion;
import com.epitech.dashboard.service.CryptoWidgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CryptoController {
    @PostMapping("/createConversionWidget")
    public String createConversionWidget(@RequestParam String src, Model model, HttpServletRequest request){
        CryptoWidgetService cryptoWidgetService = new CryptoWidgetService();
        WidgetConversion widgetConversion = cryptoWidgetService.createConversionWidget(src);

        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;
        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        widgetList.add(widgetConversion);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        return "redirect:/";
    }
    @PostMapping("/createBourseWidget")
    public String createBourseWidget(@RequestParam String src, Model model , HttpServletRequest request){
        CryptoWidgetService cryptoWidgetService = new CryptoWidgetService();
        WidgetBourse widgetBourse = cryptoWidgetService.createBourseWidget(src);
        WidgetConversion widgetConversion = cryptoWidgetService.createConversionWidget(src);

        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;
        if(widgetList == null){
            widgetList = new ArrayList<>();
        }

        widgetList.add(widgetBourse);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);
        return "redirect:/";
    }
}
