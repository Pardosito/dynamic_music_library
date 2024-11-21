package dynamicmusic.Reproductor;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Reproductor {
    private AudioSequence track1;
    private AudioSequence track2;
    private AudioSequence track3;

    public Reproductor(String file1, String file2, String file3) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (file1 != null){
            this.track1 = new AudioSequence(file1);
        }
        if (file2 != null){
            this.track2 = new AudioSequence(file2);
        }
        if (file3 != null){
            this.track3 = new AudioSequence(file3);
        }
    }

    public void horizontalSequency(){

    }

    public void verticalLayering(){
        
    }

    public void play() {
        if (track1 != null) track1.play();
        if (track2 != null) track2.play();
        if (track3 != null) track3.play();
    }
    
    public void stop() {
        if (track1 != null) track1.stop();
        if (track2 != null) track2.stop();
        if (track3 != null) track3.stop();
    }


    
}