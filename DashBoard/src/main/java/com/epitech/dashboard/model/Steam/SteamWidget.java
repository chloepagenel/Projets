package com.epitech.dashboard.model.Steam;

import com.epitech.dashboard.model.Widget;

import java.util.List;

public class SteamWidget extends Widget {
    private String steamName;
    private String profileUrl;
    private Integer lastLogOff;
    private Integer timeCreated;

    private String lastLogOut;
    private String timeElapsed;

    private List<Game> gameList;
    public SteamWidget(){
        this.id = count;
        count++;
        name="steamWidget" ;
    }
    public String getSteamName() {
        return steamName;
    }

    public void setSteamName(String steamName) {
        this.steamName = steamName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public Integer getLastLogOff() {
        return lastLogOff;
    }

    public void setLastLogOff(Integer lastLogOff) {
        this.lastLogOff = lastLogOff;
    }

    public Integer getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Integer timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public String getLastLogOut() {
        return lastLogOut;
    }

    public void setLastLogOut(String lastLogOut) {
        this.lastLogOut = lastLogOut;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
