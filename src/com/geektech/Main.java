package com.geektech;

import java.util.Random;

public class Main {
    public static String[] heroesNames = {"Арагорн", "Эомер", "Фарамир", "Арвен", "Боромир", "Леголас", "Гимли", "Гендальф"};
    public static int[] heroesHealth = {500, 450, 480, 700, 700, 430, 430, 350};
    public static int[] heroesDamage = {80, 70, 75, 0, 35, 65, 65, 30};
    public static String[] badGuys = {"Саурон", "Король Чародей"};
    public static int[] badGuysHealth = {1000, 500};
    public static int[] badGuysDamage = {100, 90};
    public static int roundNumber = 0;
    public static String medicAct = "Арвен Лечит: ";

    public static void main(String[] args) {
        System.out.println("_____War Of the Rings_____");
        while (true) {
            if (finishOfGame()) {
                break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            round();
        }
    }

    public static boolean finishOfGame() {
        int heroesHealthInt = 0;

        for (int heroes : heroesHealth) {
            heroesHealthInt += heroes;
        }

        if (heroesHealthInt <= 0) {
            System.out.println("\nBad gays win");

            return true;
        }

        int badGuysHealthInt = 0;

        for (int badGuys : badGuysHealth) {
            badGuysHealthInt += badGuys;
        }

        if (badGuysHealthInt <= 0) {
            System.out.println("\nHero win");

            return true;
        }

        return false;
    }


    public static void round() {
        roundNumber++;
        medicAct();
        System.out.println("__________ROUND" + +roundNumber + "__________");
        badGuysDamage();
        heroesDamage();
        printStatistics();
    }

    public static void badGuysDamage() {
        for (int i = 0; i < badGuysDamage.length; i++) {
            if (badGuysHealth[i] > 0) {
                for (int j = 0; j < heroesHealth.length; j++) {
                    if (heroesHealth[j] > 0) {
                        heroesHealth[j] -= badGuysDamage[i];

                        if (heroesHealth[j] < 0) {
                            heroesHealth[j] = 0;
                        }
                    }
                }
            }
        }
    }

    public static void heroesDamage() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0) {
                for (int j = 0; j < badGuysHealth.length; j++) {
                    if (badGuysHealth[j] > 0) {
                        badGuysHealth[j] -= heroesDamage[j];

                        if (badGuysHealth[j] < 0) {
                            badGuysHealth[j] = 0;
                        }
                    }
                }
            }
        }
    }

    public static void printStatistics() {
        System.out.println(badGuys + "health " + badGuysHealth + " damage [" + badGuysDamage + "]");
        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + "= health " + heroesHealth[i] + " damage [" + heroesDamage[i] + "]");

        }

        System.out.println();

        for (int i = 0; i < badGuys.length; i++) {
            System.out.println(badGuys[i] + "= health " + badGuysHealth[i] + " damage [" + badGuysDamage[i] + "]");

        }
    }

    public static void medicAct() {

        for (int i = 0; i < heroesHealth.length; i++) {

            if (heroesHealth[3] > 0) {

                if (heroesHealth[3] <=0 ) {

                    heroesHealth[3] = 0;
                }

            else if (heroesHealth[i] < 100 && heroesHealth[i] >= 0){

                    Random random = new Random();

                    int r = random.nextInt(100);

                    System.out.println("Арвен Лечит" + heroesNames[i] + " НА "

                            + r + " HP");

                    heroesHealth[i] += +r;

                    break;

                }

            }

        }

    }
}
