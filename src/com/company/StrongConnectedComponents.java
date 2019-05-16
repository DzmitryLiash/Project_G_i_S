package com.company;

import javax.swing.*;

public class StrongConnectedComponents extends JFrame {
    private JPanel panel1;
    private JButton wczytajButton;
    private JButton obliczButton;
    private JButton wyczyśćButton;
    private JTextPane rootPanel;

    public StrongConnectedComponents() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        add(rootPanel);
        setTitle("StrongConnectedComponents");
        setSize(800, 400);

    }
}
