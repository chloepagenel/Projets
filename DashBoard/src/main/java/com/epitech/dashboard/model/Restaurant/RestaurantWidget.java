package com.epitech.dashboard.model.Restaurant;

import com.epitech.dashboard.model.Widget;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RestaurantWidget extends Widget {

    ArrayList<Restaurant> restaurant;
    public RestaurantWidget() {
        this.id = count;
        count++;
        name = "restaurant";
    }
    public ArrayList<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(ArrayList<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }
}
