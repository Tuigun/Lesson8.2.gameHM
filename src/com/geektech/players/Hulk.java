package com.geektech.players;

public class Hulk extends Hero{

    public Hulk(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
