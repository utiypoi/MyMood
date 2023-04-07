package com.example.mymood;

public class Affirmation {

    private int id;
    private String titleAffirmation;
    private String description;
    private String time;
    private int photo;
    private int music;


    public Affirmation(int id, String titleAffirmation, String description, String time, int photo, int music) {
        this.id = id;
        this.titleAffirmation = titleAffirmation;
        this.description = description;
        this.time = time;
        this.photo = photo;
        this.music = music;
    }

    public String getTitleAffirmation() {
        return titleAffirmation;
    }

    public void setTitleAffirmation(String titleAffirmation) {
        this.titleAffirmation = titleAffirmation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
