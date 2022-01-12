package com.epitech.dashboard.model.gw2WvW;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class VictoryPoints {

    @SerializedName("red")
    @Expose
    private long red;
    @SerializedName("blue")
    @Expose
    private long blue;
    @SerializedName("green")
    @Expose
    private long green;

    public long getRed() {
        return red;
    }

    public void setRed(long red) {
        this.red = red;
    }

    public VictoryPoints withRed(long red) {
        this.red = red;
        return this;
    }

    public long getBlue() {
        return blue;
    }

    public void setBlue(long blue) {
        this.blue = blue;
    }

    public VictoryPoints withBlue(long blue) {
        this.blue = blue;
        return this;
    }

    public long getGreen() {
        return green;
    }

    public void setGreen(long green) {
        this.green = green;
    }

    public VictoryPoints withGreen(long green) {
        this.green = green;
        return this;
    }

}