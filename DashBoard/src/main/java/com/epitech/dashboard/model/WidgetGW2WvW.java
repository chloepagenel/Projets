package com.epitech.dashboard.model;

import com.epitech.dashboard.model.gw2WvW.Gw2Matchup;
import com.epitech.dashboard.model.gw2WvW.Gw2World;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.reflect.TypeToken;
import java.util.*;


public class WidgetGW2WvW extends Widget{
    private String getMatchUrl ;

    private String BlueIds ;
    private String GreenIds ;
    private String RedIds ;

    private String BlueNames;
    private String GreenNames;
    private String RedNames;

    private String BlueScore;
    private String GreenScore;
    private String RedScore ;

    private ArrayList<String> matchupList ;
    private String selectedMatchup;



    public WidgetGW2WvW() {
        this.id = count;
        count++;
        this.name = "gw2wvw";
        this.selectedMatchup = "2-1";
        getMatchUrl = "https://api.guildwars2.com/v2/wvw/matches?world=" ;
        this.getMatchupListApi();
        this.callGW2Api(this.selectedMatchup);
        this.fetchWorldsNamesViaIDs();
    }

    public WidgetGW2WvW(String MatchUp) {
        this.selectedMatchup = MatchUp ;
        this.id = count;
        count++;
        this.name = "gw2wvw";
        getMatchUrl = "https://api.guildwars2.com/v2/wvw/matches?world=" ;
        this.getMatchupListApi();
        this.callGW2Api(MatchUp);
        this.fetchWorldsNamesViaIDs();
    }
    public String getBlueScore(){
        return this.BlueScore;
    }

    public String getGreenIds() {
        return this.GreenIds;
    }

    public String getBlueIds() {
        return this.BlueIds;
    }
    public String getRedIds(){
        return this.RedIds ;
    }
    public String getGreenScore() {
        return GreenScore;
    }
    public String getBlueNames(){return BlueNames;}
    public String getGreenNames(){return GreenNames;}
    public String getRedNames(){return RedNames;}
    public String getRedScore() {
        return RedScore;
    }

    private void callGW2Api(String matchup){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(this.getMatchUrl+matchup, String.class);
        Gson gson = new Gson();
        Gw2Matchup setMatchup = gson.fromJson(response.getBody(), Gw2Matchup.class );


        this.BlueScore = String.valueOf(setMatchup.getVictoryPoints().getBlue());
        this.GreenScore = String.valueOf(setMatchup.getVictoryPoints().getGreen());
        this.RedScore = String.valueOf(setMatchup.getVictoryPoints().getRed());

        List<Long> blueIds = setMatchup.getAllWorlds().getBlue();
        this.BlueIds="";
        this.GreenIds="";
        this.RedIds="";
        for(int i = 0;i <blueIds.size();i++){
            System.out.println(blueIds.get(i));
                this.BlueIds += blueIds.get(i).toString()+",";
        }

        List<Long> redIds = setMatchup.getAllWorlds().getRed();
        for(int i = 0;i <redIds.size();i++){
                this.RedIds += redIds.get(i).toString()+",";
        }

        List<Long> greenIds = setMatchup.getAllWorlds().getGreen();
        for(int i = 0;i <greenIds.size();i++){
                this.GreenIds += greenIds.get(i).toString()+",";
        }


    }
    public void getMatchupListApi(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> response = restTemplate.getForEntity(this.getMatchUrl , Object[].class);
        Object ListMatchup = response.getBody();
        System.out.println(ListMatchup .getClass().getName());
        System.out.println(response.getBody());
    }
    public String getSelectedMatchup(){
        return selectedMatchup;
    }

    public void fetchWorldsNamesViaIDs(){
        Gw2World[] GreenWorlds = callWorldName(GreenIds);
        Gw2World[] BlueWorlds = callWorldName(BlueIds);
        Gw2World[] RedWorlds = callWorldName(RedIds);

        this.BlueNames="";
        this.GreenNames="";
        this.RedNames="";

        for(Gw2World world:GreenWorlds){
            this.GreenNames += world.getName()+", ";
        }
        for(Gw2World world:RedWorlds){
            this.RedNames+=world.getName()+", ";
        }
        for(Gw2World world:BlueWorlds){
            this.BlueNames+= world.getName()+", ";
        }
    }

    public Gw2World[] callWorldName(String worldsIds){
        String getWorldsUrl = "https://api.guildwars2.com/v2/worlds?ids=" ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(getWorldsUrl + worldsIds, String.class);
        Gson gson = new Gson();
        Gw2World[] gw2WorldsArray = gson.fromJson(response.getBody(), Gw2World[].class);

        return gw2WorldsArray;
    }

}
