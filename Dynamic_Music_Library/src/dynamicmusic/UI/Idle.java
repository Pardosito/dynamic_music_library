package dynamicmusic.UI;

import java.awt.Dimension;
import javax.swing.JButton;

public class Idle extends Pantalla {

    /* Constructor */
    public Idle(String title) {
        super(title);
    }

    @Override
    public void inicializarComponentes() {
        JButton vButton = new JButton("Vertical");
        vButton.setPreferredSize(new Dimension(350, 75));
        vButton.setFont(this.defaultFont);
        
        JButton hButton = new JButton("Horizontal");
        hButton.setPreferredSize(new Dimension(350, 75));
        hButton.setFont(this.defaultFont);

        this.add(vButton);
        this.add(hButton);
    }
}
