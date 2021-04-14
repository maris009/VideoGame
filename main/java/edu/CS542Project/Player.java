package edu.CS542Project;

import java.awt.*;

public class Player extends Entity{
    public Map map;
    //private SpecialSoundsSingleton s1;

    public Player(Sprite sprite, Vector2f orgin, int size, Map map) {
        super(sprite, orgin, size);
        dx = 1;
        this.map = map;


    }

    public void move(Map m) {
        if(up){

            dy = dy - acc;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
            //System.out.println("dx: "+ dx + "dy: " + dy);
        }else {
            if(dy < 0){
                dy = dy + deacc;
                if(dy > 0){
                    dy = 0;
                }
            }
            //System.out.println("dx: "+ dx + "dy: " + dy);

        }
        if(down){
            dy = dy + acc;
            if(dy > maxSpeed){
                dy = maxSpeed;
            }
           // System.out.println("dx: "+ dx + "dy: " + dy);
        }else {
            if(dy > 0){
                dy = dy - deacc;
                if(dy < 0){
                    dy = 0;
                }
            }
            //System.out.println("dx: "+ dx + "dy: " + dy);
        }
        if(left){
            dx = dx - acc;
            if(dx < -maxSpeed){
                dx = - maxSpeed;
            }
          //  System.out.println("dx: "+ dx + "dy: " + dy);
        }else {
            if(dx < 0){
                dx = dx + deacc;
                if(dx > 0){
                    dx = 0;
                }
            }
        //    System.out.println("dx: "+ dx + "dy: " + dy);

        }
        if(right){
            dx = dx + acc;
            if(dx > maxSpeed){
                dx = maxSpeed;
            }
      //      System.out.println("dx: "+ dx + "dy: " + dy);
        }else {
            if(dx > 0){
                dx = dx - deacc;
                if(dx < 0){
                    dx = 0;
                }
            }
           // System.out.println("dx: "+ dx + "dy: " + dy);
        }


    }

    public void update(){
        super.update();
        move(map);
//        if(((pos.x + dx) != -27) && ((pos.x + dx) != 816) && (((pos.y + dy) != -1) && ((pos.y + dy) != 28) ) //28*32
//        {

                if(!map.getMap((int)((pos.x + dx)/32),(int)((pos.y + dy)/32) ).equals("w"))
                {
                    pos.x += dx;
                    pos.y += dy;
                    if(map.getMap((int)((pos.x + dx)/32),(int)((pos.y + dy)/32) ).equals("F")){
                        System.out.println("YOU WON!");
                    }
                } else {

                   // SpecialSoundsSingleton m1 = SpecialSoundsSingleton.getIntance("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\resources\\punch.wav");
                }



//            }else {
//
//                pos.x += dx;
//                pos.y += dy;
           // }
       // }
        //System.out.println(map.getMap((int)((pos.x + dx)), (int)((pos.y + dy)));

        //if(pos.x == && pos.y == )
//        System.out.println("pos.x: "+ pos.x + " pos.y: " + pos.y);
//       // map.getMap((int)(pos.x), (int)(pos.y);
//        System.out.println((int)(pos.x) + " " + (int)(pos.y));
    }



    @Override
    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int)(pos.x)-16, (int)(pos.y)-28, size, size, null);

    }

    public float getTileX(){
        return pos.x;
    }

    public float getTileY(){
        return pos.y;
    }


    public void input(MouseHandler mouse, KeyHandler key){
        if(mouse.getButton() == 1){
            System.out.println("Player: "+ pos.x + ", " + pos.y);
        }

        if(key.up.down){
            up = true;

        }else {
            up = false;
        }
        if(key.down.down){
            down = true;
        }else {
            down = false;
        }
        if(key.left.down){
            left = true;
        }else{
            left = false;
        }
        if(key.right.down){
            right = true;
        }else {
            right = false;
        }
        if(key.attack.down){
            attack = true;
        }else {
            attack = false;
        }
    }
}
