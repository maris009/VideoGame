package edu.CS542Project;

public class WizardAccessoryFactory implements CharacterAccessoryFactoryIF{

    @Override
    public HatIF createHat() {
        HatIF hat = new WizardHat();

        return hat;
    }

    @Override
    public WeaponIF createWeapon() {
        WeaponIF weapon = new WizardWeapon();
        return weapon;
    }
}
