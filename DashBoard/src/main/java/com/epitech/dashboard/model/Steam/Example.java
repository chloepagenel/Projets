package com.epitech.dashboard.model.Steam;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Example {

    @SerializedName("response")
    @Expose
    private Response response;

    @SerializedName("applist")
    @Expose
    private Applist applist;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Applist getApplist() {
        return applist;
    }

    public void setApplist(Applist applist) {
        this.applist = applist;
    }

}