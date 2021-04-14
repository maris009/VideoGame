package edu.CS542Project;

import java.io.File;

public class KnightWeapon implements WeaponIF{
    File filename;
    @Override
    public File Jagger(){
        filename = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\KnightDaggerHood3.png");
        return filename;
    }
    @Override
    public File Shield(){
        filename = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\KnightDaggerHood3.png");
        return filename;
    }
}
