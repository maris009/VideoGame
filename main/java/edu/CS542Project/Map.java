package edu.CS542Project;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Map {
    private Scanner m;
    private String Map[] = new String[28];//28

    private Image grass, wall, finish;
    public Map(){
        ImageIcon img = new ImageIcon("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\wall.jpg");
        wall = img.getImage();

        ImageIcon img_grass = new ImageIcon("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\grass.jpg");
        grass = img_grass.getImage();

        ImageIcon img_finish = new ImageIcon("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\finish.jpg");
        finish = img_finish.getImage();

        openFile();
        readFile();
        closeFile();
    }

    public Image getWall(){
        return wall;
    }

    public Image getGrass(){
        return grass;
    }

    public Image getFinish(){
        return finish;
    }

    public String getMap(int x, int y){
        String index = Map[y%28].substring(x, x + 1);//28
        return index;
    }

    public void openFile(){
        try {
            // read the map.txt file
            File map = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\map\\map.txt");
            m = new Scanner(map);
        }catch (Exception e){
            System.out.println("Error loading map");
        }
    }



    public void readFile(){
        while(m.hasNext()){
            for(int i = 0; i < 28; i++)//28
            {
                Map[i] = m.next();
            }
        }
    }

    public void closeFile(){
        m.close();
    }
}

