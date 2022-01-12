package com.epitech.dashboard.service;

import com.epitech.dashboard.model.Steam.*;
import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@Service
public class SteamService {
    public SteamWidget getPlayerSummary(String steamID){
        SteamWidget steamWidget = new SteamWidget();

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Future<Response> request = client.prepareGet("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=BCA9BA6FBEF3C91AC1D5C1E2879F75AF&steamids="+steamID+"$format=json").execute();

        Response response = null;
        try {
            response = request.get();
            Gson gson = new Gson();
            Example example = gson.fromJson(response.getResponseBody(), Example.class);
            List<Player> playerList = example.getResponse().getPlayers();

            steamWidget.setSteamName(null);
            steamWidget.setLastLogOff(null);
            steamWidget.setProfileUrl(null);
            steamWidget.setTimeCreated(null);

            for (Player player : playerList) {
                steamWidget.setSteamName(player.getPersonaname());
                steamWidget.setProfileUrl(player.getProfileurl());
                steamWidget.setLastLogOff(player.getLastlogoff());
                steamWidget.setTimeCreated(player.getTimecreated());
            }

            long unixSecondsLogOff = steamWidget.getLastLogOff();
            long unixSecondsTimeCreated = steamWidget.getTimeCreated();

            Date dateLogOff = new java.util.Date(unixSecondsLogOff*1000L);
            Date dateTimeCreated = new java.util.Date(unixSecondsTimeCreated*1000L);

            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

            sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+1"));

            String formattedDateLogOff = sdf.format(dateLogOff);
            String formattedTimeCreated = sdf.format(dateTimeCreated);


            steamWidget.setLastLogOut(formattedDateLogOff);
            steamWidget.setTimeElapsed(formattedTimeCreated);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return steamWidget;
    }

    public SteamWidget getOwnedGames(String steamID, int nbrToDisplay){
        SteamWidget steamWidget = new SteamWidget();

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Future<Response> request = client.prepareGet(" http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=BCA9BA6FBEF3C91AC1D5C1E2879F75AF&steamid="+steamID+"&format=json").execute();
        Future<Response> appListRequest = client.prepareGet("https://api.steampowered.com/ISteamApps/GetAppList/v2/").execute();

        Response response = null;
        Response appResponse = null;
        try {
            response = request.get();
            appResponse = appListRequest.get();
            Gson gson = new Gson();
            Example example = gson.fromJson(response.getResponseBody(), Example.class);

            Example appExample = gson.fromJson(appResponse.getResponseBody(), Example.class);
            List<Game> games = example.getResponse().getGames();
            List<App> apps = appExample.getApplist().getApps();

            if(nbrToDisplay > games.size()){
                nbrToDisplay = games.size();
            }

            steamWidget.setGameList(new ArrayList<>());

            for(int i = 0; i < nbrToDisplay; i++){
                for (App app : apps) {
                    if (app.getAppid().equals(games.get(i).getAppid())) {
                        Game game = games.get(i);
                        game.setName(app.getName());
                        game.setPlaytime((game.getPlaytimeForever() / 60) + " h");
                        steamWidget.getGameList().add(game);
                    }
                }
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return steamWidget;
    }
}
