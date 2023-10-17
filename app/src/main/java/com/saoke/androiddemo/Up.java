package com.saoke.androiddemo;

import java.util.ArrayList;
import java.util.List;

public class Up {
    private String name;
    private int fansNumber;
    private int avatarResourceId;
    private Activity activity;

    public Up(String name, int fansNumber, int avatarResourceId) {
        this.name = name;
        this.fansNumber = fansNumber;
        this.avatarResourceId = avatarResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(int fansNumber) {
        this.fansNumber = fansNumber;
    }

    public int getAvatarResourceId() {
        return avatarResourceId;
    }

    public void setAvatarResourceId(int avatarResourceId) {
        this.avatarResourceId = avatarResourceId;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
