package DML.Player.UI;

import javax.swing.*;
import java.awt.*;

/**
 * This class sets up the basic settings used in the concrete class VerticalGUI.
 */
public abstract class Pantalla extends JFrame {

    /**
     * Attribute to set the program's font
     */
    protected final Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 30);
    /**
     * Attribute to set path to logo
     */
    private final ImageIcon LOGO = new ImageIcon("/DML/assets/Gotchards.png");
    /**
     * Attribute to set the background color
     */
    private final Color BACKGROUND = new Color(62, 180, 216);

    /**
     * Constructor
     */
    public Pantalla(String titulo) throws Exception {
        setTitle(titulo);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND);
        setIconImage(LOGO.getImage());
        setResizable(false);
        setLayout(new FlowLayout());

        inicializarComponentes();
    }

    /**
     * Color background getter
     */
    public Color getBackGround() {
        return BACKGROUND;
    }

    /**
     * Logo image getter
     */
    public ImageIcon getLogo() {
        return LOGO;
    }

    /**
     * Abstract method to load all assets which will be used when loading the program's window
     */
    protected abstract void inicializarComponentes() throws Exception;

    /**
     * Enables the visibility of the window
     */
    public void mostrar() {
        setVisible(true);
    }

}