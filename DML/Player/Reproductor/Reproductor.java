package DML.Player.Reproductor;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class serves as the Vertical Layering implementation of the project.
 */
public class Reproductor {

    private static StateManager stateManager;
    /**
     * Stores the path of the track.
     */
    public String track1Path;
    public String track2Path;
    public String track3Path;
    /**
     * Stores the AudioSequence instance for a layer of the Vertical Layering method
     */
    private AudioSequence track1;
    private AudioSequence track2;
    private AudioSequence track3;

    /**
     * Constructor. Initializes all three of the tracks with its AudioSequence instance and respective state.
     */
    public Reproductor(String file1, String file2, String file3) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (file1 != null) {
            this.track1 = new AudioSequence(file1);
            this.track1Path = file1;
            StateManager.addState("track1", false);
        }
        if (file2 != null) {
            this.track2 = new AudioSequence(file2);
            this.track2Path = file2;
            StateManager.addState("track2", false);
        }
        if (file3 != null) {
            this.track3 = new AudioSequence(file3);
            this.track3Path = file3;
            StateManager.addState("track3", false);
        }
    }

    /**
     * Stops the audio of the given track.
     */
    public void stopTrack(int trackNumber) {
        if (trackNumber < 1 || trackNumber > 3) {
            System.out.println("Not a valid track");
            return;
        }

        switch (trackNumber) {
            case 1:
                StateManager.changeState("track1", false);
                track1.stop();
                break;
            case 2:
                StateManager.changeState("track2", false);
                track2.stop();
                break;
            case 3:
                StateManager.changeState("track3", false);
                track3.stop();
                break;
        }
    }

    /**
     * Plays the audio on loop of the given track.
     */
    public void playTrack(int number) {
        if (number < 1 || number > 3) {
            System.out.println("Not a valid track");
            return;
        }

        switch (number) {
            case 1:
                StateManager.changeState("track1", true);
                track1.play();
                break;
            case 2:
                StateManager.changeState("track2", true);
                track2.play();
                break;
            case 3:
                StateManager.changeState("track3", true);
                track3.play();
                break;
        }
    }

    /**
     * Plays all tracks on loop at the same time.
     */
    public void playAll() {
        if (track1 != null) track1.play();
        if (track2 != null) track2.play();
        if (track3 != null) track3.play();
        StateManager.changeState("track1", true);
        StateManager.changeState("track2", true);
        StateManager.changeState("track3", true);
    }

    /**
     * Stops all tracks... in its tracks.
     */
    public void stopAll() {
        if (track1 != null) track1.stop();
        if (track2 != null) track2.stop();
        if (track3 != null) track3.stop();
        StateManager.changeState("track1", false);
        StateManager.changeState("track2", false);
        StateManager.changeState("track3", false);
    }
}