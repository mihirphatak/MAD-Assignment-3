// Assignment 3
// MainActivity.java
// Mihir Phatak and Aniket Shendre - Group 3

package com.example.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainForm.SelectMoodFragmentListener, SelectMood.SelectMoodFragmentListener, ProfileDisplay.ProfileDisplayListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.rootView, new MainForm(), "main-form-fragment").commit();
    }

    @Override
    public void gotoMoodSelector() {
        getSupportFragmentManager().beginTransaction().replace(R.id.rootView, new SelectMood()).addToBackStack(null).commit();
    }

    @Override
    public void gotoProfileDisplay(User user) {
        getSupportFragmentManager().beginTransaction().replace(R.id.rootView, ProfileDisplay.newInstance(user)).addToBackStack(null).commit();
    }

    @Override
    public void selectMood(int value) {
        MainForm mainForm = (MainForm) getSupportFragmentManager().findFragmentByTag("main-form-fragment");
        if(mainForm != null) {
            mainForm.setSelectedMood(value);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancel(int value) {
        MainForm mainForm = (MainForm) getSupportFragmentManager().findFragmentByTag("main-form-fragment");
        if(mainForm != null) {
            mainForm.setSelectedMood(value);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancel() {
        getSupportFragmentManager().popBackStack();
    }
}