package dynamicmusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class HorizontalResequencing{
    private static AudioSequence audioSequence;
    private static AudioSequence sequence1;
    private static AudioSequence sequence2;
    private static AudioSequence sequence3;

    private boolean isSequence1Active = false;
    private boolean isSequence2Active = false;
    private boolean isSequence3Active = false;

    public HorizontalResequencing(String path) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        audioSequence = new AudioSequence(path);
//        audioSequence.
    }

    public static void setSequence1(String startTime, String stopTime) {
        HorizontalResequencing.sequence1 = sequence1;
    }
}
