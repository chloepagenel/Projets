package com.epitech.dashboard.model.gw2account;

import java.util.List;
import javax.annotation.Generated;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Gw2Account  {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private long age;
    @SerializedName("world")
    @Expose
    private long world;
    @SerializedName("guilds")
    @Expose
    private List<String> guilds = null;
    @SerializedName("guild_leader")
    @Expose
    private List<Object> guildLeader = null;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("access")
    @Expose
    private List<String> access = null;
    @SerializedName("commander")
    @Expose
    private boolean commander;
    @SerializedName("fractal_level")
    @Expose
    private long fractalLevel;
    @SerializedName("daily_ap")
    @Expose
    private long dailyAp;
    @SerializedName("monthly_ap")
    @Expose
    private long monthlyAp;
    @SerializedName("wvw_rank")
    @Expose
    private long wvwRank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gw2Account withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gw2Account withName(String name) {
        this.name = name;
        return this;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public Gw2Account withAge(long age) {
        this.age = age;
        return this;
    }

    public long getWorld() {
        return world;
    }

    public void setWorld(long world) {
        this.world = world;
    }

    public Gw2Account withWorld(long world) {
        this.world = world;
        return this;
    }

    public List<String> getGuilds() {
        return guilds;
    }

    public void setGuilds(List<String> guilds) {
        this.guilds = guilds;
    }

    public Gw2Account withGuilds(List<String> guilds) {
        this.guilds = guilds;
        return this;
    }

    public List<Object> getGuildLeader() {
        return guildLeader;
    }

    public void setGuildLeader(List<Object> guildLeader) {
        this.guildLeader = guildLeader;
    }

    public Gw2Account withGuildLeader(List<Object> guildLeader) {
        this.guildLeader = guildLeader;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Gw2Account withCreated(String created) {
        this.created = created;
        return this;
    }

    public List<String> getAccess() {
        return access;
    }

    public void setAccess(List<String> access) {
        this.access = access;
    }

    public Gw2Account withAccess(List<String> access) {
        this.access = access;
        return this;
    }

    public boolean isCommander() {
        return commander;
    }

    public void setCommander(boolean commander) {
        this.commander = commander;
    }

    public Gw2Account withCommander(boolean commander) {
        this.commander = commander;
        return this;
    }

    public long getFractalLevel() {
        return fractalLevel;
    }

    public void setFractalLevel(long fractalLevel) {
        this.fractalLevel = fractalLevel;
    }

    public Gw2Account withFractalLevel(long fractalLevel) {
        this.fractalLevel = fractalLevel;
        return this;
    }

    public long getDailyAp() {
        return dailyAp;
    }

    public void setDailyAp(long dailyAp) {
        this.dailyAp = dailyAp;
    }

    public Gw2Account withDailyAp(long dailyAp) {
        this.dailyAp = dailyAp;
        return this;
    }

    public long getMonthlyAp() {
        return monthlyAp;
    }

    public void setMonthlyAp(long monthlyAp) {
        this.monthlyAp = monthlyAp;
    }

    public Gw2Account withMonthlyAp(long monthlyAp) {
        this.monthlyAp = monthlyAp;
        return this;
    }

    public long getWvwRank() {
        return wvwRank;
    }

    public void setWvwRank(long wvwRank) {
        this.wvwRank = wvwRank;
    }

    public Gw2Account withWvwRank(long wvwRank) {
        this.wvwRank = wvwRank;
        return this;
    }

}