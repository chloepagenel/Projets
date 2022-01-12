package com.epitech.dashboard.controller;

import com.epitech.dashboard.model.Restaurant.Example;
import com.epitech.dashboard.model.Restaurant.Location;
import com.epitech.dashboard.model.Restaurant.RestaurantWidget;
import com.epitech.dashboard.model.Restaurant.Result;
import com.epitech.dashboard.model.Widget;
import com.epitech.dashboard.service.RestaurantWidgetService;
import com.google.gson.Gson;
import org.apache.catalina.connector.Request;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class RestaurantController {
    @PostMapping("/createRestaurantWidget")
    public String createRestaurantWidget(String city, int max, Model model, HttpServletRequest request){
        List<Widget> widgetList = (List<Widget>) request.getSession().getAttribute("WIDGETS_SESSION") ;

        if(widgetList == null){
            widgetList = new ArrayList<>();
        }
        RestaurantWidgetService restaurantWidgetService = new RestaurantWidgetService();
        RestaurantWidget restaurantWidget = restaurantWidgetService.createRestaurantWidget(city, max);
        widgetList.add(restaurantWidget);
        request.getSession().setAttribute("WIDGETS_SESSION", widgetList);

        return "redirect:/";
    }
}
