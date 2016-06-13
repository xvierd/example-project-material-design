package com.example.xavier.fuffyfef.model;

/**
 * Created by xavier on 28/05/16.
 */
public class Mascot {

    private int id;
    private String name;
    private int likes = 0;
    private int image;

    public Mascot(String name, int likes, int image) {
        this.name = name;
        this.likes = likes;
        this.image = image;
    }

    public Mascot() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
