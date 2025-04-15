package org.example.casestudymodule3.model;

public class Skin {
    private int skin_id;
    private String name;
    private String thumbnail;
    private String video;
    private int price;
    private int champion_id;

    public Skin() {
    }

    public Skin(int skin_id, String name, String thumbnail, String video, int price, int champion_id) {
        this.skin_id = skin_id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.video = video;
        this.price = price;
        this.champion_id = champion_id;
    }

    public Skin(String name, String thumbnail, String video, int price, int champion_id) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.video = video;
        this.price = price;
        this.champion_id = champion_id;
    }

    public int getSkin_id() {
        return skin_id;
    }

    public void setSkin_id(int skin_id) {
        this.skin_id = skin_id;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getChampion_id() {
        return champion_id;
    }

    public void setChampion_id(int champion_id) {
        this.champion_id = champion_id;
    }
}
