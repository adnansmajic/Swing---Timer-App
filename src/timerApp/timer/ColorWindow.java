package timerApp.timer;

import javax.swing.*;
import java.awt.*;

public class ColorWindow extends JFrame {

    public ColorWindow() throws HeadlessException {
        this.setTitle("Color changer");
        this.setSize(500,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
