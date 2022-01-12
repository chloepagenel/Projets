package com.epitech.dashboard.model;

import com.epitech.dashboard.model.gw2account.Gw2Account;
import java.text.SimpleDateFormat;
import java.util.List;

public class WidgetGW2account extends Widget {
    private Gw2Account account;
    private String Userid;
    private String UserName;
    private long age;
    private long world;
    private List<String> guilds = null;
    private String created;
    private List<String> access = null;
    private boolean commander;
    private long fractalLevel;
    private long wvwRank;
    public WidgetGW2account(Gw2Account account){
        this.id = count;
        count++;
        this.name ="gw2account";
        this.account = account;
        this.Userid = account.getId();
        this.UserName = account.getName();
        this.age = account.getAge();
        this.world = account.getWorld();
        this.guilds = account.getGuilds();
        this.commander = account.isCommander();
        this.fractalLevel = account.getFractalLevel();
        this.wvwRank = account.getWvwRank();
        this.access = account.getAccess();
    }
    public String getUserid(){
        return this.Userid;
    }

    public long getAge(){
        return this.age/3600;
    }

    public String getUserName(){
        return this.UserName;
    }

    public long getWorld(){
        return this.world;
    }

    public List<String> getGuilds(){
        return this.guilds;
    }

    public boolean isCommander() {
        return commander;
    }

    public long getFractalLevel() {
        return fractalLevel;
    }

    public long getWvwRank() {
        return wvwRank;
    }

    public List<String> getAccess() {
        return access;
    }
}
