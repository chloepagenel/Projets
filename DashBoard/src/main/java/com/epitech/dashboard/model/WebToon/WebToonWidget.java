package com.epitech.dashboard.model.WebToon;

import com.epitech.dashboard.model.Widget;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class WebToonWidget extends Widget {
    private long id;
    public WebToonWidget(){
        name = "webtoonWidget";
        this.id = count;
        count++;
    }
    private List<Title> title = new ArrayList<>();

    private long userId;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Title> getTitle() {
        return title;
    }

    public void setTitle(List<Title> title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
