package com.geektech.players;

public class IronMan extends Hero{

    public IronMan(int health, int damage, String name,
                   EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
