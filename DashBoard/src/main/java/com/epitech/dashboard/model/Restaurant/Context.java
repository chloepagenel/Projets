package com.epitech.dashboard.model.Restaurant;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Context {

    @SerializedName("geo_bounds")
    @Expose
    private GeoBounds geoBounds;

    public GeoBounds getGeoBounds() {
        return geoBounds;
    }

    public void setGeoBounds(GeoBounds geoBounds) {
        this.geoBounds = geoBounds;
    }

}