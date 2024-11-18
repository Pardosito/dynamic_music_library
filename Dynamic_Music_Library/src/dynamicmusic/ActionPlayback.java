package dynamicmusic;


import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ActionPlayback {
    private static StateManager stateManager = new StateManager();
    private static Map<String, AudioSequence> audiosMap = new TreeMap<>();

    public boolean hasAction(String name) {
        return stateManager.hasState(name);
    }

    public void addAction(String filepath, String name, Boolean value) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (hasAction(name)) System.out.println("Action already exists");

        try {
            stateManager.addState(name, value);
            AudioSequence newSequence = new AudioSequence(filepath);
            audiosMap.put(name, newSequence);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void removeAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        stateManager.removeState(name);
        audiosMap.remove(name);
    }

    public void playAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        stateManager.changeState(name, true);
        AudioSequence action = audiosMap.get(name);
        action.play();
    }

    public void pauseAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        stateManager.changeState(name, false);
        AudioSequence action = audiosMap.get(name);
        action.pause();
    }

    public void resumeAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        stateManager.changeState(name, true);
        AudioSequence action = audiosMap.get(name);
        action.resumeAudio();
    }

    public void stopAction(String name) {
        if (!hasAction(name)) System.out.println("Action does not exist");

        stateManager.changeState(name, false);
        AudioSequence action = audiosMap.get(name);
        action.stop();
        action.close();
    }
}
