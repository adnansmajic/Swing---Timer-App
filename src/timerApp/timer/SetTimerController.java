package timerApp.timer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SetTimerController {
    
    //properties--------------------------------------------------------------------------------------------------------
    private final JRadioButton jRadioButton;
    private final JFormattedTextField jFormattedTextField;
    private final JTextField jTextField;
    private final JComboBox<String> cbSpeed;
    private static Color color;
    private ColorWindow colorWindow;
    private Worker worker;

    //constructor-------------------------------------------------------------------------------------------------------
    public SetTimerController(JRadioButton jRadioButton, JFormattedTextField jFormattedTextField, JTextField jTextField, JComboBox<String> cbSpeed) {
        this.jRadioButton = jRadioButton;
        this.jFormattedTextField = jFormattedTextField;
        this.jTextField = jTextField;
        this.cbSpeed = cbSpeed;
    }

    //choose color button-----------------------------------------------------------------------------------------------
    public static void chooseColor(JLabel jLabel) {
        color = JColorChooser.showDialog(null, "Choose color", Color.ORANGE);
        jLabel.setText("rgb(" + color.getRed() + "," + (color.getBlue() + "," + (color.getGreen()) + ")"));
        jLabel.setForeground(new Color(0xE86509));
    }

    //swing worker inner class------------------------------------------------------------------------------------------
    private class Worker extends SwingWorker<Void, String> {

        @Override
        protected Void doInBackground() {
            if (jRadioButton.isSelected()) {
                while (true) {
                    try {
                        LocalTime localTime = LocalTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String actualTime = dateTimeFormatter.format(localTime);
                        Thread.sleep(1000);

                        if (jFormattedTextField.getText().equals(actualTime)) {
                            colorWindow = new ColorWindow();

                            while (true) {
                                colorWindow.getContentPane().setBackground(color);
                                SetTimerController.speed(cbSpeed);
                                colorWindow.getContentPane().setBackground(new Color(238, 238, 238));
                                SetTimerController.speed(cbSpeed);
                            }
                        }
                    } catch (InterruptedException interruptedException) {
                        interruptedException.getMessage();
                    }
                }
            } else {
                for (int i = 0; i < Integer.parseInt(jTextField.getText()); i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException iex) {
                        iex.getMessage();
                    }
                }
                colorWindow = new ColorWindow();
                while (true) {
                    try {
                        colorWindow.getContentPane().setBackground(color);
                        SetTimerController.speed(cbSpeed);
                        colorWindow.getContentPane().setBackground(new Color(238, 238, 238));
                        SetTimerController.speed(cbSpeed);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        }
    }

    //change color speed Method-----------------------------------------------------------------------------------------
    public static void speed(JComboBox<String> cbSpeed) {
        try {
            if (Objects.equals(cbSpeed.getSelectedItem(), "1")) {
                Thread.sleep(1000);
            } else if (Objects.equals(cbSpeed.getSelectedItem(), "2")) {
                Thread.sleep(2000);
            } else if (Objects.equals(cbSpeed.getSelectedItem(), "3")) {
                Thread.sleep(3000);
            } else if (Objects.equals(cbSpeed.getSelectedItem(), "4")) {
                Thread.sleep(4000);
            } else {
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //start Button------------------------------------------------------------------------------------------------------
    public void startButton() {
        (worker = new Worker()).execute();
    }

    //stop Button-------------------------------------------------------------------------------------------------------
    public void stopButton() {
        if (worker != null) {
            worker.cancel(true);
            colorWindow.dispose();
        }
    }
}
