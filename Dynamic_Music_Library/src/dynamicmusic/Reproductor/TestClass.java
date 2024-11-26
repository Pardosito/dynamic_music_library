package dynamicmusic.Reproductor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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

        // ActionPlayback actions = new ActionPlayback();
        // actions.hasAction("music");
        // actions.addAction("Dynamic_Music_Library\\assets\\Cantina Band 60.wav", "music", false);

        // actions.playAction("music");

        // TimeUnit.SECONDS.sleep(5);
        // System.out.println("Pausing...");
        // actions.pauseAction("music");

        // TimeUnit.SECONDS.sleep(5);
        // System.out.println("Resuming...");
        // actions.resumeAction("music");

        // TimeUnit.SECONDS.sleep(5);
        // System.out.println("Pausing...");
        // actions.pauseAction("music");
        String file1 = "Dynamic_Music_Library\\assets\\Cantina Band 60.wav";
        Reproductor r = new Reproductor(file1, null, null);
        r.play();
        TimeUnit.SECONDS.sleep(70);
    }
}