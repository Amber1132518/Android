package com.example.homeworkapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class News implements Serializable{

    private String title;
    private String date;

    private String content;

    public News(String title, String date,String content) {
        this.title = title;
        this.date = date;
        this.content=content;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent(){return content;}
}
