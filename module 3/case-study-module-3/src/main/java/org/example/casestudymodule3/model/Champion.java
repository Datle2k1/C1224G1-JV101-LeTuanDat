package org.example.casestudymodule3.model;

public class Champion {
    protected int champion_id;
    protected String name;
    protected String thumbnail;

    public Champion() {
    }

    public Champion(int champion_id, String name, String thumbnail) {
        this.champion_id = champion_id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public Champion(String name, String thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public int getChampion_id() {
        return champion_id;
    }

    public void setChampion_id(int champion_id) {
        this.champion_id = champion_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
