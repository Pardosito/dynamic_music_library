package dynamicmusic.UI;

import java.awt.Dimension;
import javax.swing.JButton;

public class VerticalGUI extends Pantalla{
    
    public VerticalGUI(){
        super("Dynamic Library");
    }
    
    @Override
    protected void inicializarComponentes() {
        Object[][] buttons = new Object[][]{
            { "Play", 350, 75 },
            { "Stop", 350, 75 },

            { "Act1", 350, 75 },           
            { "Act2", 350, 75 },
            { "Act3", 350, 75 },
            { "Act4", 350, 75 },
            { "Horizontal", 350, 75},
            { "Vertical", 350, 75}
        };

        for (Object[] buttonConf : buttons) {
            JButton tempButton = new JButton((String) buttonConf[0]);
            tempButton.setPreferredSize(new Dimension((Integer) buttonConf[1], (Integer) buttonConf[2]));
            tempButton.setFont(this.defaultFont);

            this.add(tempButton);
        }
    }
    
}
