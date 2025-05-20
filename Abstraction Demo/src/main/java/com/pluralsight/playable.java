package com.pluralsight;


public interface playable {
void play();
void pause();
void stop();

    default void displayStatus(String status) {
        System.out.println("Current Status: " + status);
    }
}
