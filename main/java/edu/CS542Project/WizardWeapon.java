package edu.CS542Project;

import java.io.File;

public class WizardWeapon implements WeaponIF{
    File filename;
    @Override
    public File Jagger() {

        filename = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\WizardDaggerHood3.png");
        return filename;
    }

    @Override
    public File Shield() {

        filename = new File("C:\\Users\\maris\\IdeaProjects\\LabyrinthGame\\src\\images\\WizardShieldHood3.png");
        return filename;
    }
}
