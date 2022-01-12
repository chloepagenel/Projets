package com.epitech.dashboard.service;

import com.epitech.dashboard.model.Restaurant.Example;
import com.epitech.dashboard.model.Restaurant.Restaurant;
import com.epitech.dashboard.model.Restaurant.RestaurantWidget;
import com.epitech.dashboard.model.Restaurant.Result;
import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class RestaurantWidgetService {
    public RestaurantWidget createRestaurantWidget(String city, int max){
        RestaurantWidget restaurantWidget = new RestaurantWidget();
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        String longitude = "";
        String latitude = "";
        if(city.equals("Rennes")){
            longitude = "-1.6777926";
            latitude = "48.117266";
        }
        if(city.equals("Paris")){
            longitude = "2.3522219";
            latitude = "48.856614";
        }
        if(city.equals("Marseille")){
            longitude = "5.36978";
            latitude = "43.296482";
        }
        if(city.equals("Toulouse")){
            longitude = "1.444209";
            latitude = "43.604652";
        }
        if(city.equals("Lyon")){
            longitude = "4.835659";
            latitude = "45.764043";
        }
        if(city.equals("Bordeaux")){
            longitude = "-0.59444";
            latitude = "44.8378";
        }
        if(city.equals("Tours")){
            longitude = "0.6848";
            latitude = "47.3941";
        }

        Future<Response> request =  client.prepareGet("https://api.foursquare.com/v3/places/search?ll="+latitude+"%2C"+longitude+"&radius=1000&categories=13065&limit="+max)
                .setHeader("Accept", "application/json")
                .setHeader("Authorization", "fsq3HJA/zcMmc1iVtcf1QyQaamxnNvta9kcA7dDioMeOycY= ")
                .execute();

        Response response = null;
        try {
            response = request.get();
            Gson gson = new Gson();
            Example example = gson.fromJson(response.getResponseBody(), Example.class);

            List<Result> results = example.getResults();

            restaurantWidget.setRestaurant(new ArrayList<>());

            for(int i = 0; i < results.size(); i++){
                Restaurant restaurant = new Restaurant(results.get(i).getName(), results.get(i).getLocation().getAddress() +" "+ results.get(i).getLocation().getLocality());
                restaurantWidget.getRestaurant().add(restaurant);
            }
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        return restaurantWidget;
    }
}
