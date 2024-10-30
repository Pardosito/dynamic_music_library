package dynamicmusic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioSequence {
    private final String path;
    private final File file;
    private Clip clip;
    private String status;
    private long currentFrame;

    public AudioSequence(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.path = path;
        this.file = new File(path).getAbsoluteFile();
        this.status = "stop";

        if (!file.exists()) {
            throw new IOException("File not found: " + path);
        }

        clip = AudioSystem.getClip();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
    }

    public void play() {
        try {
            if (status.equals("pause")) {
                resumeAudio();
                return;
            }

            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            status = "play";

        } catch (Exception e) {
            System.err.println("Error during playback: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void pause() {
        if (status.equals("play")) {
            currentFrame = clip.getFramePosition();
            clip.stop();
            status = "pause";
        }
    }

    public void resumeAudio() {
        if (status.equals("pause")) {
            clip.setFramePosition((int)currentFrame);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            status = "play";
        }
    }

    public void stop() {
        clip.stop();
        clip.setFramePosition(0);
        status = "stop";
    }

    public void close() {
        stop();
        clip.close();
    }
}