package kg.geektech_general;

import kg.geekteach_Playears.*;

import java.util.Random;

public class RPG_Game {
    private static int raundnumber;
    public static Random random = new Random();

    public static void startGame() {
        System.out.println(" ROUND " + raundnumber + "  ----------------------------");
        Boss boss = new Boss(1000, 50, "Ursa");
        Warrior warrior = new Warrior(270, 10, " Garrosh ");
        Medic doc = new Medic(250, 5, " Paladin Master ", 15);
        Magic magic = new Magic(260, 20, " Crystalys Magik");
        Berserk berserk = new Berserk(280, 15, " Mungo Bers");
        Medic assistant = new Medic(290, 10, " Shaman 1lvl", 5);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant};

        PrintStatistics(boss, heroes);
        while (!IsGameFinished(boss, heroes)) {
            playRaund(boss, heroes);
        }
    }

    private static void playRaund(Boss boss, Hero[] heroes) {
        raundnumber++;
        boss.choosDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getAbility() != boss.getDefence()
            && heroes[i].getHealth() >0) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        PrintStatistics(boss, heroes);
    }

    private static void PrintStatistics(Boss boss, Hero[] heroes) {
        System.out.println();
        System.out.println(boss); // получаем ссылку надо... В геймЭнтити создать возращяемый метод to.String
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean IsGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            boss.setHealth(0);
            System.out.println(" Heroes won!!!");
            return true;
        }
        boolean allHeroesDeat = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDeat = false;
                break;
            }
        }
        if (allHeroesDeat) {
            System.out.println(" Boss won!!!");
        }
        return allHeroesDeat;
    }
}
