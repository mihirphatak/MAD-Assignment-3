package com.example.fragmentsdemo;

import java.io.Serializable;

public class User implements Serializable {
    String name, age;
    int moodState;

    public User(String name, String age, int moodState) {
        this.name = name;
        this.age = age;
        this.moodState = moodState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getMoodState() {
        return moodState;
    }

    public void setMoodState(int moodState) {
        this.moodState = moodState;
    }
}
