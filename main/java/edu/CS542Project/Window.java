package edu.CS542Project;

import javax.swing.*;

public class Window extends JFrame {


    public Window(){

//        KeyListener kl = new KeyAdapter() {
//            public void KeyPressed(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
//                    System.exit(0);
//            }
//        };
        JFrame frame = new JFrame();
        frame.setTitle("LABYRINTH MAZE");
//        frame.addKeyListener(kl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GamePanel(896,896));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args){

        new Window();

    }


}
