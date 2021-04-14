package edu.CS542Project;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    // anything that can move will use this class
    private final int UP=0;
    private final int DOWN = 2;
    private final int RIGHT = 3;
    private final int LEFT = 1;
    protected int currentAnimation;

    protected Animation ani;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean attack;
    protected int attackSpeed;
    protected int attackDuration;

    protected float dx;
    protected float dy;

    protected float maxSpeed = 4f;
    protected float acc = 4f;
    protected float deacc = 4f;

    protected AABB hitBounds; //hit box
    protected AABB bounds;


    public Entity(Sprite sprite, Vector2f orgin, int size){ //constructor
        this.sprite = sprite;
        pos = orgin;
        this.size = size;

        bounds = new AABB(orgin, size, size);

        hitBounds = new AABB(new Vector2f(orgin.x + (size/2), orgin.y), size, size); // offsets the object to be on the middle

        ani = new Animation();
        setAnimation(RIGHT,sprite.getSpriteArray(RIGHT), 10);
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public void setSize( int i){
        size = i;
    }

   public void setMaxSpeed(float f){
        maxSpeed = f;
    }

    public void setAcc(float f){
        acc = f;
    }

    public void setDeacc(float f ){
        deacc = f;
    }

    public AABB getHitBounds(){
        return bounds;
    }

    public int getSize(){
        return size;
    }

    public Animation getAnimation(){
        return ani;
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay){
        currentAnimation = i;
        ani.setFrames(frames);
        ani.setDelay(delay);

    }

    public void animate(){
        if(up){
            if(currentAnimation != UP || ani.getDelay() == -1){
                setAnimation(UP, sprite.getSpriteArray(UP), 5);

            }
        }else if(down){
            if(currentAnimation != DOWN || ani.getDelay() == -1){
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
            }
        }else if(left){
            if(currentAnimation != LEFT || ani.getDelay() == -1){
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
            }
        }else if(right){
            if(currentAnimation != RIGHT || ani.getDelay() == -1){
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
            }
        }else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }

    }

    private void setHitBoxDirection(){
        if(up){
            hitBounds.setXOffset(-size / 2);
            hitBounds.setYOffset(-size / 2);

        }else if(down){
            hitBounds.setXOffset(size / 2);
            hitBounds.setYOffset(-size / 2);

        }else if(left){
            hitBounds.setXOffset(-size / 2);
            hitBounds.setYOffset(0);

        }else if(right){
            hitBounds.setXOffset(0);
            hitBounds.setYOffset(0);
        }
    }


    public void update(){
        animate();
        setHitBoxDirection();
        ani.update();
    }

    public abstract void render(Graphics2D g);


}
