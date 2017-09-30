package com.fratane.max.swiperecyclerview.model;

/**
 * Created by Max_F on 30/09/2017.
 */

public class Team {
    private String imgUrl;
    private String name;

    public Team(){

    }

    public Team(String imgUrl, String name) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
