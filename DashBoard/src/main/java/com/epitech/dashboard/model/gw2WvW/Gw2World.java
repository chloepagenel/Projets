package com.epitech.dashboard.model.gw2WvW;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Gw2World {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("population")
    @Expose
    private String population;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gw2World withId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gw2World withName(String name) {
        this.name = name;
        return this;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Gw2World withPopulation(String population) {
        this.population = population;
        return this;
    }

}