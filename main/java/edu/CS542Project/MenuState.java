package edu.CS542Project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class MenuState extends GameState {
    JFrame window;
    Container con;
    JPanel titleNamePanel, resumeButtonPanel, menu1ButtonPanel, menu2ButtonPanel, playButtonPanel, menu3ButtonPanel, menu4ButtonPanel;
    JLabel titleNameLabel;
    java.awt.Font titleFont = new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 90);
    java.awt.Font resumeFont = new java.awt.Font("Times New Roman", Font.PLAIN, 20);
    public static final Color dark_green = new Color(0,65, 0);
    JButton resumeButton, menu1PlayerButton, menu1BackButton, menu2BackButton,menu2WizardButton, menu2KnightButton;
    JButton newGameButton, playButton, menu3CapButton, menu3HoodButton, menu3BackButton, menu4BackButton;
    JButton exitButton, menu4ShieldButton, menu4JaggerButton;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    Menu1ScreenHandler menu1ScreenHandler = new Menu1ScreenHandler();
    Menu2ScreenHandler menu2ScreenHandler = new Menu2ScreenHandler();
    Menu3ScreenHandler menu3ScreenHandler = new Menu3ScreenHandler();
    String position, player, typeHat, typeWeapon;
    JFrame frame;
    EscapeFrame escapeFrame = new EscapeFrame();
    KeyHandler key;

    MenuMusicSingleton m1;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        window = new JFrame();
        window.setLayout(null);
//        tsHandler = null;

//        window.setSize(900,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            File fileName = new File("C:\\Users\\maris\\IdeaProjects\\MusicTest\\src\\resources\\Maze1.jpg");
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(fileName));
            window.setContentPane(new JLabel(imageIcon));
            window.setPreferredSize(new Dimension(950,950));
            window.setLocationRelativeTo(null);
        }catch (IOException e){
            e.printStackTrace();
        }
        MenuMusicSingleton m1 = MenuMusicSingleton.getIntance();
        this.m1 = m1;
        m1.play();

        window.pack();
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(150, 100, 600, 150);
        titleNamePanel.setOpaque(false);

        titleNameLabel = new JLabel("Labyrinth Game");
        titleNameLabel.setForeground(dark_green);
        titleNameLabel.setFont(titleFont);

        playButtonPanel = new JPanel();
        playButtonPanel.setBounds(350,300,200,200);
        playButtonPanel.setOpaque(false);


        playButton = new JButton("PLAY GAME");
        playButton.setForeground(Color.white);
        playButton.setBackground(dark_green);
        playButton.setFont(resumeFont);
        playButton.addActionListener(menu1ScreenHandler);
        playButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        playButtonPanel.add(playButton);
//        resumeButtonPanel.add(newGameButton);
//        resumeButtonPanel.add(exitButton);

        con.add(titleNamePanel);
        con.add(playButtonPanel);

    }

    @Override
    public void update() {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {

    }

    public void createGameScreen(){
//        window.setVisible(false);
        titleNamePanel.setVisible(false);
        playButtonPanel.setVisible(false);

        if(tsHandler != null){
            m1.stop();
        }
        gsm.add(0);
//        JFrame frame = new JFrame();
//        frame.setTitle("LABYRINTH MAZE");
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        GamePanel gp = new GamePanel(896,896);
//        frame.setContentPane(gp);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
        // PlayState.
//        gp.getActionForKeyStroke(KeyEvent.VK_ESCAPE);
//        this.key = gp.getKey();

//        JPanel frame1 = new JPanel();
//        frame.setTitle("LABYRINTH MAZE");

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        GamePanel gp = new GamePanel(896,896);
//        window.setContentPane(gp);
//        window.pack();
//        window.setLocationRelativeTo(null);
//
////        this.key = gp.getKey();




    }

    public void createMenuO(){
        position = "menu0";
        //titleNamePanel.setVisible(false);
        playButtonPanel.setVisible(false);

        resumeButtonPanel = new JPanel();
        resumeButtonPanel.setBounds(350,300,200,200);
        resumeButtonPanel.setOpaque(false);


        resumeButton = new JButton("RESUME");
        //resumeButton.setSize(50,50);
        resumeButton.setForeground(Color.white);
        resumeButton.setBackground(dark_green);
        resumeButton.setFont(resumeFont);
        resumeButton.addActionListener(tsHandler);
        resumeButton.setFocusPainted(false);

        newGameButton = new JButton("NEW GAME");
        newGameButton.setForeground(Color.white);
        newGameButton.setBackground(dark_green);
        newGameButton.setFont(resumeFont);
        newGameButton.addActionListener(menu2ScreenHandler);
        newGameButton.setActionCommand("m0ng");
        newGameButton.setFocusPainted(false);

        exitButton = new JButton("EXIT");
        exitButton.setForeground(Color.white);
        exitButton.setBackground(dark_green);
        exitButton.setFont(resumeFont);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(menu2ScreenHandler);
        exitButton.setActionCommand("m0e");

        titleNamePanel.add(titleNameLabel);
        resumeButtonPanel.add(resumeButton);
        resumeButtonPanel.add(newGameButton);
        resumeButtonPanel.add(exitButton);

        con.add(titleNamePanel);
        con.add(resumeButtonPanel);

    }

    public void createMenu1(){

        resumeButtonPanel.setVisible(false);

        position = "menu1";



        menu1ButtonPanel = new JPanel();
        menu1ButtonPanel.setBounds(350,300,200,200);
        menu1ButtonPanel.setOpaque(false);

        menu1BackButton = new JButton("BACK");
        menu1BackButton.setForeground(Color.white);
        menu1BackButton.setBackground(dark_green);
        menu1BackButton.setFont(resumeFont);
        menu1BackButton.addActionListener(menu2ScreenHandler);
        menu1BackButton.setActionCommand("m1b");
        menu1BackButton.setFocusPainted(false);

        menu1PlayerButton = new JButton("PLAYER");
        menu1PlayerButton.setForeground(Color.white);
        menu1PlayerButton.setBackground(dark_green);
        menu1PlayerButton.setFont(resumeFont);
        menu1PlayerButton.addActionListener(menu2ScreenHandler);
        menu1PlayerButton.setActionCommand("m1p");
        menu1PlayerButton.setFocusPainted(false);



        menu1ButtonPanel.add(menu1BackButton);

        menu1ButtonPanel.add(menu1PlayerButton);



        con.add(menu1ButtonPanel);



    }

    public void createMenu2(){

        position = "menu2";

        menu1ButtonPanel.setVisible(false);


        menu2ButtonPanel = new JPanel();
        menu2ButtonPanel.setBounds(350,300,200,200);
        menu2ButtonPanel.setOpaque(false);

        menu2BackButton = new JButton("BACK");

        menu2BackButton.setForeground(Color.white);
        menu2BackButton.setBackground(dark_green);
        menu2BackButton.setFont(resumeFont);
        menu2BackButton.addActionListener(menu2ScreenHandler);
        menu2BackButton.setActionCommand("m2b");
        menu2BackButton.setFocusPainted(false);

        menu1PlayerButton.setText("Wizard");

        menu2WizardButton = new JButton("WIZARD");
        menu2WizardButton.setForeground(Color.white);
        menu2WizardButton.setBackground(dark_green);
        menu2WizardButton.setFont(resumeFont);
        menu2WizardButton.addActionListener(menu2ScreenHandler);
        menu2WizardButton.setActionCommand("m2w");
        menu2WizardButton.setFocusPainted(false);

        menu2KnightButton = new JButton("KNIGHT");
        menu2KnightButton.setForeground(Color.white);
        menu2KnightButton.setBackground(dark_green);
        menu2KnightButton.setFont(resumeFont);
        menu2KnightButton.addActionListener(menu2ScreenHandler);
        menu2KnightButton.setActionCommand("m2k");
        menu2KnightButton.setFocusPainted(false);


        menu2ButtonPanel.add(menu2BackButton);
        menu2ButtonPanel.add(menu2WizardButton);
        menu2ButtonPanel.add(menu2KnightButton);

        con.add(menu2ButtonPanel);



    }

    public void createMenu3(){

        position = "menu3";

        menu2ButtonPanel.setVisible(false);

        menu3ButtonPanel = new JPanel();
        menu3ButtonPanel.setBounds(350,300,200,200);
        menu3ButtonPanel.setOpaque(false);

        menu3BackButton = new JButton("BACK");

        menu3BackButton.setForeground(Color.white);
        menu3BackButton.setBackground(dark_green);
        menu3BackButton.setFont(resumeFont);
        menu3BackButton.addActionListener(menu2ScreenHandler);
        menu3BackButton.setActionCommand("m3b");
        menu3BackButton.setFocusPainted(false);

        menu3HoodButton = new JButton("  HOOD  ");
        menu3HoodButton.setForeground(Color.white);
        menu3HoodButton.setBackground(dark_green);
        menu3HoodButton.setFont(resumeFont);
        menu3HoodButton.addActionListener(menu2ScreenHandler);
        menu3HoodButton.setActionCommand("m3h");
        menu3HoodButton.setFocusPainted(false);

        menu3CapButton = new JButton("   CAP   ");
        menu3CapButton.setForeground(Color.white);
        menu3CapButton.setBackground(dark_green);
        menu3CapButton.setFont(resumeFont);
        menu3CapButton.addActionListener(menu2ScreenHandler);
        menu3CapButton.setActionCommand("m3c");
        menu3CapButton.setFocusPainted(false);


        menu3ButtonPanel.add(menu3BackButton);
        menu3ButtonPanel.add(menu3HoodButton);
        menu3ButtonPanel.add(menu3CapButton);

        con.add(menu3ButtonPanel);



    }

    public void createMenu4(){

        position = "menu4";

        menu3ButtonPanel.setVisible(false);

        menu4ButtonPanel = new JPanel();
        menu4ButtonPanel.setBounds(350,300,200,200);
        menu4ButtonPanel.setOpaque(false);

        menu4BackButton = new JButton("BACK");

        menu4BackButton.setForeground(Color.white);
        menu4BackButton.setBackground(dark_green);
        menu4BackButton.setFont(resumeFont);
        menu4BackButton.addActionListener(menu2ScreenHandler);
        menu4BackButton.setActionCommand("m4b");
        menu4BackButton.setFocusPainted(false);

        menu4ShieldButton = new JButton(" SHIELD ");
        menu4ShieldButton.setForeground(Color.white);
        menu4ShieldButton.setBackground(dark_green);
        menu4ShieldButton.setFont(resumeFont);
        menu4ShieldButton.addActionListener(menu2ScreenHandler);
        menu4ShieldButton.setActionCommand("m4s");
        menu4ShieldButton.setFocusPainted(false);

        menu4JaggerButton = new JButton(" JAGGER ");
        menu4JaggerButton.setForeground(Color.white);
        menu4JaggerButton.setBackground(dark_green);
        menu4JaggerButton.setFont(resumeFont);
        menu4JaggerButton.addActionListener(menu2ScreenHandler);
        menu4JaggerButton.setActionCommand("m4j");
        menu4JaggerButton.setFocusPainted(false);


        menu4ButtonPanel.add(menu4BackButton);
        menu4ButtonPanel.add(menu4ShieldButton);
        menu4ButtonPanel.add(menu4JaggerButton);

        con.add(menu4ButtonPanel);

    }

    public class EscapeFrame extends JFrame implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("keyTyped");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_ESCAPE)
                frame.setVisible(false);
        }
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

    public class Menu1ScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            createMenuO();
        }
    }

    public class Menu2ScreenHandler implements ActionListener{



        public void actionPerformed(ActionEvent e) {
            String mChoice = e.getActionCommand();
            switch (position) {
                case "menu0":
                    switch (mChoice) {
                        case "m0ng":
                            createMenu1();
                            break;
                        case "m0e":
                            System.exit(0);
                            break;
                    }
                    break;
                case "menu1":
                    switch (mChoice) {
                        case "m1b":
                            menu1ButtonPanel.setVisible(false);
                            createMenuO();
                            break;
                        case "m1p":
                            createMenu2();
                            break;
                    }
                    break;
                case "menu2":
                    switch (mChoice) {
                        case "m2b":
                            menu2ButtonPanel.setVisible(false);
                            createMenu1();
                            break;
                        case "m2w":
                            createMenu3();
                            player = "Wizard";
                            break;
                        case "m2k":
                            createMenu3();
                            player = "Knight";
                            break;
                    }
                    break;
                case "menu3":
                    switch (mChoice) {
                        case "m3b":
                            menu3ButtonPanel.setVisible(false);
                            createMenu2();
                            break;
                        case "m3h":
                            createMenu4();
                            typeHat = "Hood";
                            break;
                        case "m3c":
                            createMenu4();
                            typeHat = "Cap";
                            break;
                    }
                    break;
                case "menu4":
                    switch (mChoice) {
                        case "m4b":
                            menu4ButtonPanel.setVisible(false);
                            createMenu3();
                            break;
                        case "m4s":
                            typeWeapon = "Shield";
                            System.out.println(player+" "+typeHat+" "+typeWeapon);
                            break;
                        case "m4j":
                            typeWeapon = "Jagger";
                            System.out.println(player+" "+typeHat+" "+typeWeapon);
                            break;
                    }
                    break;
            }
        }
    }

//    public abstract class EscapableFrame extends JFrame(){
//
//    }

    public class Menu3ScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String mChoice = e.getActionCommand();
            switch (mChoice){
                case "m0ng": createMenu1();
                case "m0e": System.exit(0);
            }
//            createMenu2();
        }
    }



}
