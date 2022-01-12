package com.epitech.dashboard.model.Restaurant;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Location {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("admin_region")
    @Expose
    private String adminRegion;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("cross_street")
    @Expose
    private String crossStreet;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("region")
    @Expose
    private String region;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(String adminRegion) {
        this.adminRegion = adminRegion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}