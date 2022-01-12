package com.epitech.dashboard.model.gw2WvW;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Gw2Matchup {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("all_worlds")
    @Expose
    private AllWorlds allWorlds;
    @SerializedName("victory_points")
    @Expose
    private VictoryPoints victoryPoints;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gw2Matchup withId(String id) {
        this.id = id;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Gw2Matchup withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Gw2Matchup withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public AllWorlds getAllWorlds() {
        return allWorlds;
    }

    public void setAllWorlds(AllWorlds allWorlds) {
        this.allWorlds = allWorlds;
    }

    public Gw2Matchup withAllWorlds(AllWorlds allWorlds) {
        this.allWorlds = allWorlds;
        return this;
    }

    public VictoryPoints getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(VictoryPoints victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public Gw2Matchup withVictoryPoints(VictoryPoints victoryPoints) {
        this.victoryPoints = victoryPoints;
        return this;
    }

}