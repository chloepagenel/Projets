package com.epitech.dashboard.service;

import com.epitech.dashboard.model.WidgetGW2account;
import com.epitech.dashboard.model.gw2account.Gw2Account;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Gw2service {
    private  String accountUrl ="https://api.guildwars2.com/v2/account?access_token=";

    public Gw2Account getAccountApiCall(String id){
        RestTemplate restTemplate = new RestTemplate();
        this.accountUrl += id;
        ResponseEntity<String> response = restTemplate.getForEntity(this.accountUrl , String.class);
        Gson gson = new Gson();
        Gw2Account UserAccount = gson.fromJson(response.getBody(), Gw2Account.class);
        System.out.println(UserAccount);
        return UserAccount;
    }
    public WidgetGW2account createWidgetGW2Account(Gw2Account account){
        WidgetGW2account Widget = new WidgetGW2account(account);
        return Widget;
    }
}
