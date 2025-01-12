package DML.Player.Reproductor;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class creates and manages all audio files used in the library.
 */
public class AudioSequence {
    /**
     * Stores the path to the audio file (Only .wav supported)
     */
    private final String path;
    /**
     * Holds an instance of a File to manage the use of AudioInputStream instances.
     */
    private final File file;
    /**
     * Deals with all the audio behaviour, from playing to stopping, etc.
     */
    private final Clip clip;
    /**
     * Stores the total number of frames an audio is composed of.
     */
    private final long length;
    /**
     * Current state value of the instance. (Is it playing or not?)
     */
    private String status;
    /**
     * Stores the frame where the instance was paused.
     */
    private long currentFrame;

    /**
     * Constructor.
     */
    public AudioSequence(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.path = path;
        this.file = new File(path).getAbsoluteFile();
        this.status = "stop";

        if (!file.exists()) {
            throw new IOException("File not found: " + path);
        }

        this.clip = AudioSystem.getClip();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.file);
        this.length = audioInputStream.getFrameLength();
        this.clip.open(audioInputStream);
    }

    /**
     * Plays the audio of an action on loop.
     */
    public void play() {
        try {
            if (!clip.isOpen()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip.open(audioInputStream);
            }

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            status = "play";

        } catch (Exception e) {
            System.err.println("Error during playback: " + e.getMessage());
        }
    }

    /**
     * Plays the audio of an action for its total duration.
     */
    public void playAction() {
        try {
            if (clip.isRunning()) {
                clip.stop();
            }

            clip.setFramePosition(0);

            if (!clip.isOpen()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip.open(audioInputStream);
            }

            clip.start();
            status = "play";

        } catch (Exception e) {
            System.err.println("Error during playback: " + e.getMessage());
        }
    }

    /**
     * Pauses the audio of an action and returns the stopping frame.
     */
    public long pause() {
        if (status.equals("play")) {
            currentFrame = clip.getFramePosition();
            clip.stop();
            status = "pause";
        }
        return currentFrame;
    }

    /**
     * Resumes an action's audio in the given frame.
     */
    public void resumeAudio(long frame) {
        if (status.equals("pause")) {
            clip.setFramePosition((int) frame);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            status = "play";
        }
    }

    /**
     * Stops and restarts the audio of an action.
     */
    public void stop() {
        clip.stop();
        clip.setFramePosition(0);
        status = "stop";
    }

    /**
     * Stops and closes the audio's Clip instance.
     */
    public void close() {
        stop();
        clip.close();
    }

    /**
     * Returns the current frame where an audio stopped.
     */
    public long getCurrentFrame() {
        return this.currentFrame;
    }

    /**
     * Returns the length of the audio.
     */
    public long getLength() {
        return this.length;
    }
}