package dynamicmusic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioSequence {
    private final String path;
    private final File file;
    private final long length;
    private final double lengthInSeconds;
    private final AudioFormat format;
    private final int frameSize;
    private final float frameRate;
    private Clip clip;

    public AudioSequence(String path) throws UnsupportedAudioFileException, IOException {
        this.path = path;
        this.file = new File(path);

        if (!file.exists()) {
            throw new IOException("File not found: " + path);
        }

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
            this.format = audioInputStream.getFormat();
            this.frameSize = format.getFrameSize();
            this.length = audioInputStream.getFrameLength();
            this.frameRate = format.getFrameRate();
            this.lengthInSeconds = (this.length / (double)(frameSize * frameRate));
        }
    }

    public void playSequence() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.file);
            Clip clip = AudioSystem.getClip();
            System.out.println(this.lengthInSeconds);
            clip.open(audioInputStream);
            clip.start();
            while (clip.isActive()) {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.err.println("Error during playback: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }
    }

}