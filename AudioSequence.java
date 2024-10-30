package dynamicmusic;//package dynamicmusic;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioSequence {
    private final String path;
    private final File file;
    private final long length;
    private final double lengthInSeconds;
    private final AudioFormat format;
    private AudioInputStream audioInputStream;
    private final int frameSize;
    private final float frameRate;
    private long currentFrame;
    private Clip clip;
    private String status;

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

    public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            new Thread(() -> {
                while (clip.isRunning()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    restart();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            this.status = "play";
        } catch (Exception e) {
            System.err.println("Error during playback: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }
    }

    public void pause() {
        if(clip.isRunning() && clip != null && !this.status.equals("pause")) {
            this.currentFrame = this.clip.getMicrosecondPosition();
            clip.stop();
            this.status = "pause";
        }
        else System.out.println("Audio already paused");
    }

    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, InterruptedException {
        if (this.status.equals("play"))
        {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void restart() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException, InterruptedException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException, InterruptedException {
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


