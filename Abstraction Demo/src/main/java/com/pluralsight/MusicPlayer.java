package com.pluralsight;

public class MusicPlayer implements playable {
private String CurrentTrack;
public MusicPlayer (String Track){
    this.CurrentTrack = Track;

}

    public void play(){
    System.out.println ("playing Music:" + CurrentTrack );
    displayStatus("playing");
    }

    public void pause(){
    System.out.println(" pausing Music:"+ CurrentTrack);
    displayStatus("pause");
    }

    public void stop(){
    System.out.println("stopping Music: "+ CurrentTrack);
    }
}








