package timerApp;

import timerApp.timer.SetTimerView;

import javax.swing.*;
import java.text.ParseException;

public class TimerApp extends JFrame {

    public static void main(String[] args) throws ParseException {

        //Option pane---------------------------------------
        int yourSide = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Settings", "Close"}, null);

        switch (yourSide) {
            case JOptionPane.YES_OPTION:
                new SetTimerView();
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
        }
    }
}
