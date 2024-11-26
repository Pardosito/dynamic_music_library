package dynamicmusic.Reproductor;

import java.io.IOException;
import javax.sound.sampled.*;

public class Reproductor {

    //Attributes
    private AudioSequence track1;
    private AudioSequence track2;
    private AudioSequence track3;

    //Constructor
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

    //Methods

    public void horizontalSequency(){

    }

    public void verticalLayering(boolean layer1, boolean layer2, boolean layer3) {
        if (layer1 && track1 != null) {
            track1.play();
        } else if (track1 != null) {
            track1.stop();
        }
    
        if (layer2 && track2 != null) {
            track2.play();
        } else if (track2 != null) {
            track2.stop();
        }
    
        if (layer3 && track3 != null) {
            track3.play();
        } else if (track3 != null) {
            track3.stop();
        }
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