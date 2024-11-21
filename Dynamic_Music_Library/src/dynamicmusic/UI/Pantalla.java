package dynamicmusic.UI;

import java.awt.*;
import javax.swing.*;

public abstract class Pantalla extends JFrame{

    /* Atributes */
    private final ImageIcon LOGO = new ImageIcon(Pantalla.class.getResource("/assets/Gotchards.jpg"));
    private final Color BACKGROUND = Color.BLACK;
    protected final Font defaultFont = new Font("Comic Sans MS", Font.PLAIN, 30);

    /* Constructor */
    public Pantalla(String titulo){
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

    /* Getters */
    public Color getBackGround() {
        return BACKGROUND;
    }

    public ImageIcon getLogo(){
        return LOGO;
    }

    /* Methods */
    protected abstract void inicializarComponentes();

    public void mostrar(){
        setVisible(true);
    }

}