package dynamicmusic.UI;

import java.awt.Dimension;
import javax.swing.JButton;

public class VerticalGUI extends Pantalla{
    
    public VerticalGUI(){
        super("Vertical Layering");
    }
    
    @Override
    protected void inicializarComponentes() {
        Object[][] buttons = new Object[][]{
            { "Act1", 350, 75 }, 
            { "Play", 350, 90 },
            { "Act2", 350, 75 },
            { "Act3", 350, 75 },
            { "Stop", 350, 90 },
            { "Act4", 350, 90 },
        };

        for (Object[] buttonConf : buttons) {
            JButton tempButton = new JButton((String) buttonConf[0]);
            tempButton.setPreferredSize(new Dimension((Integer) buttonConf[1], (Integer) buttonConf[2]));
            tempButton.setFont(this.defaultFont);

            this.add(tempButton);
        }
    }
    
}
