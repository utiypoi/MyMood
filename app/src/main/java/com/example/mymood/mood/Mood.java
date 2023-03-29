package com.example.mymood.mood;

public class Mood {

    private String title;
    private String dateTime;
    private String comment;

    public Mood(String title, String dateTime, String comment) {
        this.title = title;
        this.dateTime = dateTime;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
