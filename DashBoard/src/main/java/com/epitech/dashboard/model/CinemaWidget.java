package com.epitech.dashboard.model;

import com.omertron.omdbapi.OmdbApi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.omertron.omdbapi.OmdbApi;

import java.util.ArrayList;

public class CinemaWidget extends Widget {
    private long id;

    private String actors;
    private String resume;
    private String awards;
    private String writer;
    private String image;
    private String title;
    private OmdbApi omdbApi;

    private String error;

    private ArrayList<String> ListTitleYear;

    private ArrayList<String> ListImage;

    public CinemaWidget(){
        this.id = count;
        count++;
        name = "cinemaWidget";
    }

    public CinemaWidget(OmdbApi omdbApi){
        this.id = count;
        count++;
        name = "cinemaWidget";
        this.omdbApi = omdbApi;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OmdbApi getOmdbApi() {
        return omdbApi;
    }

    public void setOmdbApi(OmdbApi omdbApi) {
        this.omdbApi = omdbApi;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<String> getListTitleYear() {
        return ListTitleYear;
    }

    public void setListTitleYear(ArrayList<String> listTitleYear) {
        ListTitleYear = listTitleYear;
    }

    public ArrayList<String> getListImage() {
        return ListImage;
    }

    public void setListImage(ArrayList<String> listImage) {
        ListImage = listImage;
    }
}
