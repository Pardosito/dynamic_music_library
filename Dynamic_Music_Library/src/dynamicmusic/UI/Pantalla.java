package dynamicmusic.UI;

import java.awt.*;
import javax.swing.*;

public abstract class Pantalla extends JFrame{
    private static final ImageIcon logo = new ImageIcon("Dynamic_Music_Library\\assets\\Gotchards.png");
    private static final Color backGround = Color.BLACK;

    public Pantalla(String titulo){
        setTitle(titulo);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(backGround);

        inicializarComponentes();
    }

    protected abstract void inicializarComponentes();

    public void mostrar(){
        setVisible(true);
    }

    public static ImageIcon getLogo(){
        return logo;
    }

}
