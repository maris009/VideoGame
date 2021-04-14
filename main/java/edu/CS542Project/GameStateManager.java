package edu.CS542Project;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;
    private ArrayList<String> currentStates = new ArrayList<String>();

    private int state;

    public static Vector2f map;

    public static final int PLAY = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;

//    public boolean getState(int state){
//        return states[state] != null;
//    }
//    public void setStates(int choice){
//        this.state = choice;
//        System.out.println(state);
//    }

    public void printStates(){
        System.out.println(states);
    }

    public int getState(){
        return state;
    }

    public GameStateManager(){
        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);
        states = new ArrayList<GameState>();
//        states.add(new MenuState(this));
       states.add(new PlayState(this));

//        states.add(new GameOverState(this));
//        states.add(new PauseState(this));

    }

    public void pop( int state){

        states.remove(state);
    }

    public void addstates(int state){

    }

    public void add(int state){
        if (state == PLAY){
            states.add(new PlayState(this));
        }
        if(state == MENU){
            states.add(new MenuState(this));
        }
        if(state == PAUSE){
            states.add(new PauseState(this));
        }
        if(state == GAMEOVER){
            states.add(new GameOverState(this));
        }
    }

    public void addAndpop(int state){
        states.remove(0);
        add(state);
    }

    public void update(){
        Vector2f.setWorldVar(map.x, map.y);
        for(int i = 0; i < states.size(); i++){
            states.get(i).update();
        }
    }

    public void input(MouseHandler mouse, KeyHandler key){
        for(int i = 0; i < states.size(); i++){
            states.get(i).input(mouse, key);
            //System.out.println(key);
        }

    }

    public void render(Graphics2D g){
        for(int i = 0; i < states.size(); i++){
            states.get(i).render(g);
        }

    }


    public static void main(String[] args){
        new GameStateManager();
//        gsm.add(1);
//        gsm.printStates();



//        new Window();

    }
}
