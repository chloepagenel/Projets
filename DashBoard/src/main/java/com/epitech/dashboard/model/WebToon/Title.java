package com.epitech.dashboard.model.WebToon;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Title {

    @SerializedName("titleNo")
    @Expose
    private Integer titleNo;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("writingAuthorName")
    @Expose
    private String writingAuthorName;
    @SerializedName("representGenre")
    @Expose
    private String representGenre;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("serviceStatus")
    @Expose
    private String serviceStatus;
    @SerializedName("newTitle")
    @Expose
    private Boolean newTitle;
    @SerializedName("hotTitle")
    @Expose
    private Boolean hotTitle;
    @SerializedName("starScoreAverage")
    @Expose
    private Double starScoreAverage;
    @SerializedName("readCount")
    @Expose
    private Integer readCount;
    @SerializedName("likeitCount")
    @Expose
    private Integer likeitCount;
    @SerializedName("lastEpisodeRegisterYmdt")
    @Expose
    private Long lastEpisodeRegisterYmdt;
    @SerializedName("totalServiceEpisodeCount")
    @Expose
    private Integer totalServiceEpisodeCount;
    @SerializedName("registerYmdt")
    @Expose
    private Long registerYmdt;

    public Integer getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(Integer titleNo) {
        this.titleNo = titleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWritingAuthorName() {
        return writingAuthorName;
    }

    public void setWritingAuthorName(String writingAuthorName) {
        this.writingAuthorName = writingAuthorName;
    }

    public String getRepresentGenre() {
        return representGenre;
    }

    public void setRepresentGenre(String representGenre) {
        this.representGenre = representGenre;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Boolean getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(Boolean newTitle) {
        this.newTitle = newTitle;
    }

    public Boolean getHotTitle() {
        return hotTitle;
    }

    public void setHotTitle(Boolean hotTitle) {
        this.hotTitle = hotTitle;
    }

    public Double getStarScoreAverage() {
        return starScoreAverage;
    }

    public void setStarScoreAverage(Double starScoreAverage) {
        this.starScoreAverage = starScoreAverage;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getLikeitCount() {
        return likeitCount;
    }

    public void setLikeitCount(Integer likeitCount) {
        this.likeitCount = likeitCount;
    }

    public Long getLastEpisodeRegisterYmdt() {
        return lastEpisodeRegisterYmdt;
    }

    public void setLastEpisodeRegisterYmdt(Long lastEpisodeRegisterYmdt) {
        this.lastEpisodeRegisterYmdt = lastEpisodeRegisterYmdt;
    }

    public Integer getTotalServiceEpisodeCount() {
        return totalServiceEpisodeCount;
    }

    public void setTotalServiceEpisodeCount(Integer totalServiceEpisodeCount) {
        this.totalServiceEpisodeCount = totalServiceEpisodeCount;
    }

    public Long getRegisterYmdt() {
        return registerYmdt;
    }

    public void setRegisterYmdt(Long registerYmdt) {
        this.registerYmdt = registerYmdt;
    }
}