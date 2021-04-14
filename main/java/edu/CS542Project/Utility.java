package edu.CS542Project;

public class Utility {
    public static CharacterAccessoryFactoryIF createAccessoryFactory(String style){
        switch(style) {
            case "Wizard": {
                return new WizardAccessoryFactory();
            }

            case "Knight": {
                return new KnightAccessoryFactory();
            }

            default : {
                return null;
            }
        }
    }
}
