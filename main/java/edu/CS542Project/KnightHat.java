package edu.CS542Project;

import java.io.File;

public class KnightHat implements HatIF{
    File filename;
    @Override
    public File Cap() {
        filename = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\KnightDaggerHood3.png");
        return filename;
    }

    @Override
    public File Hood() {
        filename = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\KnightDaggerHood3.png");
        return filename;
    }
}
