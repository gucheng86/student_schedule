package gui.frame;

import gui.panel.MainPanel;
import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    public MainFrame() {
        setSize(500, 540);
        setTitle("java作业");
        setContentPane(MainPanel.instance);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
