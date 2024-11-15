package dynamicmusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestClass {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
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

        ActionPlayback actions = new ActionPlayback();
        actions.hasAction("music");
        actions.addAction("/Users/pardosito/Desktop/Kodiguito/POO/dynamicmusic/Cantina Band 60.wav", "music", false);
        actions.hasAction("music");
        actions.addAction("/Users/pardosito/Desktop/Kodiguito/POO/dynamicmusic/Cantina Band 60.wav", "music", false);
        actions.playAction("music");

        TimeUnit.SECONDS.sleep(5);
        System.out.println("Pausing...");
        actions.pauseAction("music");

        TimeUnit.SECONDS.sleep(5);
        System.out.println("Resuming...");
        actions.resumeAction("music");

        TimeUnit.SECONDS.sleep(5);
        System.out.println("Pausing...");
        actions.pauseAction("music");


    }
}