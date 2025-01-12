package DML.Player.UI;

import DML.Player.Reproductor.ActionPlayback;
import DML.Player.Reproductor.Reproductor;
import DML.Player.Reproductor.StateManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This class serves as the GUI for the project.
 */

public class VerticalGUI extends Pantalla {
    private static StateManager stateManager;
    ActionPlayback actions;
    Reproductor reproductor = new Reproductor("DML/assets/More Jazz Guitar by Sub-d.wav", "DML/assets/Piano Melody by benpm.wav", "DML/assets/Untitled.wav");
    private JButton playButton;
    private JButton stopButton;
    private JButton eatingButton;
    private JButton walkingButton;
    private JButton hitButton;
    private JButton damageButton;
    private JButton drumsButton;
    private JButton guitarButton;
    private JButton pianoButton;

    /**
     * Constructor
     */
    public VerticalGUI() throws Exception {
        super("Dynamic Library");
        actions = new ActionPlayback();
    }

    /**
     * Creates a button instance with the desired width and height.
     */
    public JButton createButton(String name, int width, int height) {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(this.defaultFont);
        button.setFocusPainted(true);
        this.add(button);
        return button;
    }

    /**
     * Assigns a button instance to the declared button attributes.
     */
    public void createButtons() {
        playButton = createButton("Play", 350, 75);
        stopButton = createButton("Stop", 350, 75);
        eatingButton = createButton("Eating", 350, 75);
        hitButton = createButton("Hit", 350, 75);
        walkingButton = createButton("Walking", 350, 75);
        damageButton = createButton("Damage", 350, 75);
        pianoButton = createButton("Piano", 350, 75);
        guitarButton = createButton("Guitar", 350, 75);
        drumsButton = createButton("Drums", 350, 75);
    }

    /**
     * Adds new actions to ActionPlayback map with its appropriate path, action name, and value.
     * It is preferred the action name matches its associated button name.
     */
    public void addActions() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        actions.addAction("DML/assets/steve damage.wav", "Damage", false);
        actions.addAction("DML/assets/minecraft walking.wav", "Walking", false);
        actions.addAction("DML/assets/minecraft hit.wav", "Hit", false);
        actions.addAction("DML/assets/minecraft eating.wav", "Eating", false);
    }

    /**
     * Associates each button to its respective action.
     * Uses functional programming to improve readability and reduce total lines.
     */
    public void addActionListeners() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        stopButton.addActionListener(e -> {
            reproductor.stopAll();
        });
        playButton.addActionListener(e -> {
            reproductor.playAll();
        });
        damageButton.addActionListener(e -> actions.playAction(damageButton.getText()));
        hitButton.addActionListener(e -> actions.playAction(hitButton.getText()));
        eatingButton.addActionListener(e -> actions.playAction(eatingButton.getText()));
        walkingButton.addActionListener(e -> {
            if (StateManager.getStateValue(walkingButton.getText())) {
                actions.stopAction(walkingButton.getText());
            } else {
                actions.loopAction(walkingButton.getText());
            }
        });

        guitarButton.addActionListener(e -> {
            if (StateManager.getStateValue("track1")) {
                reproductor.stopTrack(1);
            } else {
                reproductor.playTrack(1);
            }
        });

        pianoButton.addActionListener(e -> {
            if (StateManager.getStateValue("track2")) {
                reproductor.stopTrack(2);
            } else {
                reproductor.playTrack(2);
            }
        });

        drumsButton.addActionListener(e -> {
            if (StateManager.getStateValue("track3")) {
                reproductor.stopTrack(3);
            } else {
                reproductor.playTrack(3);
            }
        });
    }

    @Override
    protected void inicializarComponentes() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        actions = new ActionPlayback();
        createButtons();
        addActions();
        addActionListeners();
    }
}

