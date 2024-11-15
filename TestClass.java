package dynamicmusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestClass {
    public static void main(String[] args) {
//        try {
//            AudioSequence audioSequence = new AudioSequence("/Users/pardosito/Desktop/Kodiguito/POO/dynamicmusic/Cantina Band 60.wav");
//
//            System.out.println("Starting playback...");
//            System.out.println(audioSequence.getLength());
//            audioSequence.play();
//
//            TimeUnit.SECONDS.sleep(5);
//            System.out.println("Pausing...");
//            audioSequence.pause();
//
//            TimeUnit.SECONDS.sleep(5);
//            System.out.println("Resuming...");
//            audioSequence.resumeAudio();
//
//            TimeUnit.SECONDS.sleep(30);
//
//            audioSequence.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        StateManager stateManager = new StateManager();
        stateManager.addState("Running", false);
        stateManager.addState("Walking", false);
        stateManager.addState("Punch", false);
        stateManager.addState("Running", false);
        stateManager.changeState("Walking", true);

        stateManager.printStates();
    }
}