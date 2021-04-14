package edu.CS542Project;

import java.awt.*;


public class PlayState extends GameState{


    private Player player;

    private Map map;

    private MusicSingleton m1;

    private String[] args;

    public PlayState(GameStateManager gsm){
        super(gsm);

        MazeGenTest mazeGenTest= new MazeGenTest(28);
        this.map = new Map();

        player = new Player(new Sprite("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\WizardDaggerHood3.png"), new Vector2f(32, 0), 32, map);

        m1 = MusicSingleton.getIntance();
        m1.play();



    }

    public void update(){
        player.update();


    }

    public void input(MouseHandler mouse, KeyHandler key){
        key.escape.tick();
        player.input(mouse, key);

//        if(key.escape.clicked){
//            System.out.println("ESC clicked");
//            System.out.println(key.escape.clicked);
//            gsm.setStates(2);
//        }

    }

    public void render(Graphics2D g){
        //Sprite.drawArray(g, font, "Your Mom", new Vector2f(100,100),32, 32,16,0);

        Sprite.drawMap(g, map);
        player.render(g);
    }

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }



}
