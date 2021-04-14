package edu.CS542Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {


    private Map m;


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
