package com.pluralsight;
class VideoPlayer implements playable {
    private String currentVideo;

    public VideoPlayer(String video) {
        this.currentVideo = video;
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + currentVideo);
        // Using the default method from the interface
        displayStatus("Video Playing");
    }

    @Override
    public void pause() {
        System.out.println("Pausing video: " + currentVideo);
        displayStatus("Video Paused");
    }

    @Override
    public void stop() {
        System.out.println("Stopping video: " + currentVideo);
        displayStatus("Video Stopped");
    }

    // Overriding the default method (optional)
    @Override
    public void displayStatus(String status) {
        System.out.println("Video Player Status Update: " + status);
    }
}
