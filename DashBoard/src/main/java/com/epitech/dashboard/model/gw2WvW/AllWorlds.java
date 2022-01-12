package com.epitech.dashboard.model.gw2WvW;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class AllWorlds {

    @SerializedName("red")
    @Expose
    private List<Long> red ;
    @SerializedName("blue")
    @Expose
    private List<Long> blue ;
    @SerializedName("green")
    @Expose
    private List<Long> green ;

    public List<Long> getRed() {
        return red;
    }

    public void setRed(List<Long> red) {
        this.red = red;
    }

    public AllWorlds withRed(List<Long> red) {
        this.red = red;
        return this;
    }

    public List<Long> getBlue() {
        return blue;
    }

    public void setBlue(List<Long> blue) {
        this.blue = blue;
    }

    public AllWorlds withBlue(List<Long> blue) {
        this.blue = blue;
        return this;
    }

    public List<Long> getGreen() {
        return green;
    }

    public void setGreen(List<Long> green) {
        this.green = green;
    }

    public AllWorlds withGreen(List<Long> green) {
        this.green = green;
        return this;
    }

}