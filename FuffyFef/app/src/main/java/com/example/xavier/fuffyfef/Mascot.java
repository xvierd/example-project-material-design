package com.example.xavier.fuffyfef;

/**
 * Created by xavier on 28/05/16.
 */
public class Mascot {
    private String name;
    private int likes = 0;
    private int image;
    private int totalLikes = 0;

    public Mascot(String name, int likes, int image, int totalLikes) {
        this.name = name;
        this.likes = likes;
        this.image = image;
        this.totalLikes = totalLikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }
}
