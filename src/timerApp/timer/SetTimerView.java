package timerApp.timer;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class SetTimerView extends JFrame {

    public SetTimerView() throws HeadlessException, ParseException {

        //JRadio Buttons---------------------------------------------------------------------------------------------------
        JRadioButton rbOnTime = new JRadioButton(" on time:                                  ");
        rbOnTime.setSelected(true);
        JRadioButton rbCountdown = new JRadioButton(" countdown(mins)                ");

        //ButtonGroup------------------------------------------------------------------------------------------------------
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbCountdown);
        buttonGroup.add(rbOnTime);

        //JTextFields------------------------------------------------------------------------------------------------------
        JFormattedTextField ftfOnTime = new JFormattedTextField(new MaskFormatter("##:##:##"));
        JTextField tfCountdown = new JTextField("0");
        ftfOnTime.setFont(new Font("Courier New", Font.PLAIN, 12));
        tfCountdown.setFont(new Font("Courier New", Font.PLAIN, 12));
        ftfOnTime.setColumns(11);
        tfCountdown.setColumns(11);

        //JLabels----------------------------------------------------------------------------------------------------------
        JLabel lfake1 = new JLabel("                                          ");
        JLabel lfake2 = new JLabel("                                          ");
        JLabel lfake3 = new JLabel("                                          ");
        JLabel lfake4 = new JLabel("                                          ");
        JLabel lfake5 = new JLabel("                                          ");
        JLabel lfake6 = new JLabel("                                   ");
        JLabel lfake7 = new JLabel("                                    ");
        JLabel lfake8 = new JLabel("                                   ");
        JLabel lcolorInfo = new JLabel("No color selected");
        JLabel lspeed = new JLabel("Speed:                              ");
        lcolorInfo.setPreferredSize(new Dimension(132, 15));

        //JButtons-----------------------------------------------------------------------------------------------------------
        JButton bChooseColor = new JButton("  Choose color  ");
        JButton bStart = new JButton("  Start  ");
        JButton bStop = new JButton("  Stop  ");

        //JComboBox----------------------------------------------------------------------------------------------------------
        String[] stringsSpeed = {"1","2","3","4","5"};
        JComboBox<String> cbSpeed = new JComboBox<>(stringsSpeed);

        //JPanel-------------------------------------------------------------------------------------------------------------
        JPanel jpTop = new JPanel(new FlowLayout());
        jpTop.add(rbOnTime);        jpTop.add(ftfOnTime);
        jpTop.add(rbCountdown);     jpTop.add(tfCountdown);
        jpTop.add(lfake1);          jpTop.add(lfake2);
        jpTop.add(bChooseColor);    jpTop.add(lcolorInfo);
        jpTop.add(lfake3);          jpTop.add(lfake4);
        jpTop.add(lspeed);          jpTop.add(lfake5);
        jpTop.add(cbSpeed);         jpTop.add(lfake6);
        jpTop.add(lfake7);          jpTop.add(bStart);
        jpTop.add(lfake8);          jpTop.add(bStop);

        //Events-------------------------------------------------------------------------------------------------------------
        SetTimerController setTimerController = new SetTimerController(rbOnTime,ftfOnTime,tfCountdown,cbSpeed);

        bChooseColor.addActionListener(e -> SetTimerController.chooseColor(lcolorInfo));
        bStart.addActionListener(e -> setTimerController.startButton());
        bStop.addActionListener(e -> setTimerController.stopButton());

        //JFrame-------------------------------------------------------------------------------------------------------------
        this.setSize(300, 265);
        this.setResizable(false);
        this.setLayout(new GridLayout(1, 1));
        this.add(jpTop);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

