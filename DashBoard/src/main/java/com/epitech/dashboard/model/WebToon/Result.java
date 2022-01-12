package com.epitech.dashboard.model.WebToon;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {

    @SerializedName("challengeSearch")
    @Expose
    private ChallengeSearch challengeSearch;

    public ChallengeSearch getChallengeSearch() {
        return challengeSearch;
    }

    public void setChallengeSearch(ChallengeSearch challengeSearch) {
        this.challengeSearch = challengeSearch;
    }

}