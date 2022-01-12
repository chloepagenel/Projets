package com.epitech.dashboard.model.Steam;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Game {

    @SerializedName("appid")
    @Expose
    private Integer appid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("playtime_forever")
    @Expose
    private Integer playtimeForever;
    @SerializedName("playtime_windows_forever")
    @Expose
    private Integer playtimeWindowsForever;
    @SerializedName("playtime_mac_forever")
    @Expose
    private Integer playtimeMacForever;
    @SerializedName("playtime_linux_forever")
    @Expose
    private Integer playtimeLinuxForever;
    @SerializedName("playtime_2weeks")
    @Expose
    private Integer playtime2weeks;

    @SerializedName("playtime")
    @Expose
    private String playtime;

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlaytimeForever() {
        return playtimeForever;
    }

    public void setPlaytimeForever(Integer playtimeForever) {
        this.playtimeForever = playtimeForever;
    }

    public Integer getPlaytimeWindowsForever() {
        return playtimeWindowsForever;
    }

    public void setPlaytimeWindowsForever(Integer playtimeWindowsForever) {
        this.playtimeWindowsForever = playtimeWindowsForever;
    }

    public Integer getPlaytimeMacForever() {
        return playtimeMacForever;
    }

    public void setPlaytimeMacForever(Integer playtimeMacForever) {
        this.playtimeMacForever = playtimeMacForever;
    }

    public Integer getPlaytimeLinuxForever() {
        return playtimeLinuxForever;
    }

    public void setPlaytimeLinuxForever(Integer playtimeLinuxForever) {
        this.playtimeLinuxForever = playtimeLinuxForever;
    }

    public Integer getPlaytime2weeks() {
        return playtime2weeks;
    }

    public void setPlaytime2weeks(Integer playtime2weeks) {
        this.playtime2weeks = playtime2weeks;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }
}