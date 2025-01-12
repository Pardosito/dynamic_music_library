package DML.Player.Reproductor;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/**
 * This class is in charge of managing the audio playback of simple actions such as "Walk", "Punch", "Eat".
 * It uses the static class StateManager for the states of its actions as well as AudioSequence to deal with all things audio related.
 * Its actions can be both finite and infinite, depending on the method being used to play the aforementioned action.
 */
public class ActionPlayback {
    private static StateManager stateManager = new StateManager();

    /**
     * Stores the action created in the StateManager to an AudioSequence instance which plays the audio.
     */
    private static final Map<String, AudioSequence> audiosMap = new TreeMap<>();

    /**
     * Uses the static method hasState to check in the map whether the received action (name) exists or not.
     * Mostly used as an auxiliary method to other methods.
     */
    public boolean hasAction(String name) {
        return StateManager.hasState(name);
    }

    /**
     * If the action (name) does not already exist, adds it to the map as a key with its assigned value
     */
    public void addAction(String filepath, String name, Boolean value) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (hasAction(name)) System.out.println("Action already exists");

        try {
            StateManager.addState(name, value);
            AudioSequence newSequence = new AudioSequence(filepath);
            audiosMap.put(name, newSequence);
            StateManager.printStates();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes the action from the map. Doesn't do anything if actions does not exist.
     */
    public void removeAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        StateManager.removeState(name);
        audiosMap.remove(name);
    }

    /**
     * Plays the audio linked to the action (name) only once. Uses AudioSequence for audio controls and StateManager for updating the value of the states to match its intended behaviour.
     */
    public void playAction(String name) {
        System.out.println(name);
        if (!hasAction(name)) System.out.println("Action does not exist");

        AudioSequence action = audiosMap.get(name);
        if (StateManager.getStateValue(name)) {
            action.stop();
            action.close();
        }

        StateManager.changeState(name, true);
        action.playAction();
    }

    /**
     * Plays the audio linked to the action (name) until told not to. Uses AudioSequence for audio controls and StateManager for updating the value of the states to match its intended behaviour.
     */
    public void loopAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        AudioSequence action = audiosMap.get(name);
        StateManager.changeState(name, true);
        action.play();
    }

    /**
     * Pauses the audio linked to the action (name) and returns the stop frame in order to store it for use in resumeAction().
     */
    public long pauseAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        StateManager.changeState(name, false);
        AudioSequence action = audiosMap.get(name);
        action.pause();
        long frame = action.getCurrentFrame();
        return frame;
    }

    /**
     * Starts playing audio linked to the action (name) according to frame given as a parameter.
     */
    public void resumeAction(String name, long frame) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        StateManager.changeState(name, true);
        AudioSequence action = audiosMap.get(name);
        action.resumeAudio(frame);
    }

    /**
     * Stops the audio from the action (name) being played. Closes and restarts the line used.
     */
    public void stopAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        StateManager.changeState(name, false);
        AudioSequence action = audiosMap.get(name);
        action.stop();
        action.close();
    }
}
