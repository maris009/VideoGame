package edu.CS542Project;

import java.awt.*;

public class PauseState extends GameState {

    public PauseState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void update() {
    System.out.println("PAUSED");
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        key.escape.tick();
        if(key.escape.clicked){
            gsm.pop(GameStateManager.PAUSE);
        }
    }

    @Override
    public void render(Graphics2D g) {

    }
}
