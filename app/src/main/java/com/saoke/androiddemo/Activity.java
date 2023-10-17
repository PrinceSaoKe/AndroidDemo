package com.saoke.androiddemo;

import java.util.List;

public class Activity {
    private Up up;
    private int image;
    private String text;
    private int likesNumber = 0;
    private int commentNumber = 0;
    private int shareNumber = 0;

    Activity(Up up, String text, int image) {
        this.up = up;
        this.text = text;
        this.image = image;
    }

    public Up getUp() {
        return up;
    }

    public void setUp(Up up) {
        this.up = up;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(int likesNumber) {
        this.likesNumber = likesNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(int shareNumber) {
        this.shareNumber = shareNumber;
    }
}
