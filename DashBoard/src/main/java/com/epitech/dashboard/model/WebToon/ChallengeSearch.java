package com.epitech.dashboard.model.WebToon;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ChallengeSearch {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("display")
    @Expose
    private Integer display;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("titleList")
    @Expose
    private List<Title> titleList = null;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

}