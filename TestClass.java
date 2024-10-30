package dynamicmusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass {
    public static void main(String[] args) {
        try {
            AudioSequence audioSequence = new AudioSequence("/Users/pardosito/Desktop/Kodiguito/POO/dynamicmusic/Cantina Band 60.wav");

            System.out.println("Starting playback...");
            audioSequence.play();

            TimeUnit.SECONDS.sleep(5);
            System.out.println("Pausing...");
            audioSequence.pause();

            TimeUnit.SECONDS.sleep(5);
            System.out.println("Resuming...");
            audioSequence.resumeAudio();

            TimeUnit.SECONDS.sleep(30);

            audioSequence.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}