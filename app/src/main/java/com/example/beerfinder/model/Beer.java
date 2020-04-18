package com.example.beerfinder.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Beer {

    //Default consstructor

    public Beer(){}

    //Attributes

    @PrimaryKey
    private int beerId;

    private String description;

    private String tagline;

    private double abv;


    //Constructor


    //Getters and Setters


    public int getBeerId() {
        return beerId;
    }

    public String getDescription() {
        return description;
    }

    public String getTagline() {
        return tagline;
    }

    public double getAbv() {
        return abv;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }
}
