package com.pluralsight;

public class MediaDemo {
    public static void main(String[] args) {
        playable myMusic = new MusicPlayer("New person, Same old mistakes:");
        playable myVideo = new VideoPlayer("Sinners");

        // Client code interacts with the objects through the Playable interface
        // It doesn't need to know if it's a MusicPlayer or VideoPlayer specifically
        // to perform these actions.
        System.out.println("--- Music Player ---");
        myMusic.play();
        myMusic.pause();
        myMusic.stop();

        System.out.println("\n--- Video Player ---");
        myVideo.play();
        myVideo.pause();
        myVideo.stop();

        // Demonstrating polymorphism with an array
        playable [] mediaCollection = {
                new MusicPlayer("Breathe Deeper"),
                new VideoPlayer("Warriors Highlights"),
                new MusicPlayer("Get Lucki")
        };

        System.out.println("\n--- Media Collection ---");
        for (playable media : mediaCollection) {
            media.play(); // The correct play() method is called based on the actual object type
            System.out.println("------");
        }
    }
}