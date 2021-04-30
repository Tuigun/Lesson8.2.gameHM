package com.geektech.game;

import com.geektech.players.*;
import sun.security.mscapi.CPublicKey;

import java.util.Random;

public class InfinityWar {

    public static void startBattle(){
        Boss thanos = new Boss(1000, 50,
                "Thanos");

        CaptainAmerica captainAmerica = new CaptainAmerica(
                250, 25, "Captain America",
                EnumSuperAbility.SHIELD_STRIKE);

        IronMan ironMan = new IronMan(
                220, 30, "Iron Man",
                EnumSuperAbility.SUPER_SHOOT);

        Hulk hulk = new Hulk(
                300, 35, "Hulk",
                EnumSuperAbility.ALL_CRASH);

        Medic doc = new Medic(
                220, 5, "Doctor",
                EnumSuperAbility.TO_HEAL, 15);

        Medic assistant = new Medic(
                240, 5, "Assistant",
                EnumSuperAbility.TO_HEAL,10);

        Hero[] avengers = {captainAmerica, ironMan,
                hulk, doc, assistant};

        System.out.println("_____THE INFINITY WAR IS STARTED_____");
        printStatistics(thanos, avengers);
        avengers[0].setDamage(avengers[0].getDamage() + (thanos.getDamage()/2));
        



        while (!isGameFinished(thanos, avengers)){
            round(thanos, avengers);
        }
    }

    private static void round(Boss thanos, Hero[] avengers){
        bossDamage(thanos, avengers);
        avengersDamage(thanos, avengers);
        applySuperAbility(thanos, avengers);
        printStatistics(thanos, avengers);
    }

    private static boolean isGameFinished(Boss boss, Hero[] avengers){
        if (boss.getHealth() <= 0){
            System.out.println("Avengers won!!!");
            return true;
        }

        boolean allAvengersDead = true;
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0){
                allAvengersDead = false;
                break;
            }
        }
        if (allAvengersDead){
            System.out.println("Thanos Won!!!");
        }
        return allAvengersDead;
    }

    private static void avengersDamage(Boss boss, Hero[] avengers){
        for (int i = 0; i < avengers.length; i++) {
            if (boss.getHealth() > 0 && avengers[i].getHealth() > 0){
                boss.setHealth(boss.getHealth() - avengers[i].getDamage());
            }else {
                avengers[i].setDamage(0);
            }
            avengers[i].setDamage((int) (avengers[i].getDamage() + Math.random() * 5));

        }
        System.out.println("IronMan увеличил урон героев ");
    }

    private static void applySuperAbility(Boss boss, Hero[] avengers){
        for (int i = 0; i < avengers.length; i++) {
            if (boss.getHealth() > 0 && avengers[i].getHealth() > 0){
                avengers[i].applySuperAbility(boss, avengers);
            }

        }
    }

    private static void bossDamage(Boss boss, Hero[] avengers){
        for (int i = 0; i < avengers.length; i++) {
            if (boss.getHealth() > 0 && avengers[i].getHealth() > 0){
                avengers[i].setHealth(avengers[i].getHealth() - boss.getDamage());
            }
        }
    }

    public static void printStatistics(Boss boss, Hero[] avengers){
        System.out.println(boss.getName() + " : " +
                boss.getHealth() + " damage " +
                boss.getDamage());
        for (int i = 0; i < avengers.length; i++) {
            System.out.println(avengers[i].getName() + " : " +
                    avengers[i].getHealth() + " damage " +
                    avengers[i].getDamage());
        }
        System.out.println("_________________");
    }
}
