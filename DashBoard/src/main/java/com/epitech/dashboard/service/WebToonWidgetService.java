package com.epitech.dashboard.service;

import com.epitech.dashboard.model.WebToon.Example;
import com.epitech.dashboard.model.WebToon.Title;
import com.epitech.dashboard.model.WebToon.WebToonWidget;
import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class WebToonWidgetService {

    public WebToonWidget createWebToonWidget(String title){
        WebToonWidget webToonWidget = new WebToonWidget();

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Future<Response> request =  client.prepareGet("https://webtoon.p.rapidapi.com/canvas/search?query="+title+"&pageSize=20&language=en")
                .setHeader("x-rapidapi-host", "webtoon.p.rapidapi.com")
                .setHeader("x-rapidapi-key", "558fc0684amshd7b23a4f42e21f2p1646d9jsn0a6c40ab013d")
                .execute();


        Response response = null;
        try {
            response = request.get();
            Gson gson = new Gson();
            Example example = gson.fromJson(response.getResponseBody(), Example.class);

            List<Title> titles = example.getMessage().getResult().getChallengeSearch().getTitleList();
            webToonWidget.setTitle(titles);

            client.close();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
        return webToonWidget;
    }
}
