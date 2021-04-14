package edu.CS542Project;

public class KnightAccessoryFactory implements CharacterAccessoryFactoryIF{

    @Override
    public HatIF createHat() {
        HatIF hat = new KnightHat();
        return hat;
    }

    @Override
    public WeaponIF createWeapon() {
        WeaponIF weapon = new KnightWeapon();
        return weapon;
    }
}
