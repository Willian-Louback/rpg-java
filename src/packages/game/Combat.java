package packages.game;

import java.util.Scanner;

import packages.mobs.Enemy;
import packages.mobs.Skeleton;
import packages.mobs.Zombie;
import packages.player.Player;

public class Combat {
    private static Scanner scanner = new Scanner(System.in);
    private String result;

    public String init(Player player) {
        Enemy enemy = generateEnemy();
        boolean fight = true;

        System.out.println("Um " + enemy.getName() + " apareceu!");
        do {
            System.out.println("1. Atacar\n2. Fugir");
            int choice = Integer.valueOf(scanner.nextLine());

            if(choice == 1) {
                fight = battle(player, enemy);
            } else {
                System.out.println("Você fugiu covardemente, parabéns!");
                fight = false;
            }
        } while(fight);

        return end();
    }

    private boolean battle(Player player, Enemy enemy) {
        System.out.println("Você atacou o inimigo!");
        boolean death = player.hit(enemy);

        if(death) {
            result = "win";
            return false;
        } else {
            boolean deathP = enemy.hit(player);

            if(deathP) {
                result = "lost";
                return false;
            }

            return true;
        }
    }

    private Enemy generateEnemy() {
        int randomNumber = (int) (Math.random() * 2);

        if(randomNumber == 0) {
            return new Zombie();
        } else if(randomNumber == 1) {
            return new Skeleton();
        } else {
            return null;
        }
    }

    private String end() {
        return result;
    }
}
