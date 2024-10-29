package dynamicmusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        AudioSequence audioSequence = new AudioSequence("/Users/pardosito/Desktop/Kodiguito/POO/dynamicmusic/Cantina Band 60.wav");
        audioSequence.playSequence();
    }
}