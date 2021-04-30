package com.geektech.players;

public class CaptainAmerica extends Hero{

    public CaptainAmerica(int health, int damage, String name,
                          EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);

        }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }


}
