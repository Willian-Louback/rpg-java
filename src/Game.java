import java.util.Scanner;

import packages.game.Combat;
import packages.player.Arqueiro;
import packages.player.Gladiador;
import packages.player.Necromante;
import packages.player.Player;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        menu();
        start();
    }

    private static void menu() {
        System.out.println("Digite \"1\" para continuar ou \"2\" para ler o tutorial!");
        int choice = Integer.valueOf(scanner.nextLine());

        if(choice == 1) {
            return;
        } else {
            tutorial();
        }
    }

    private static void start() {
        System.out.println("Seja bem-vindo, jogador!");
        String name;
        do {
            System.out.print("Digite o seu nome para continuar: ");
            name = scanner.nextLine();
        }
        while(confirmChoice() != 1);

        System.out.println("Certo, " + name + "! Escolha a sua classe:");

        Player player = choiceCharacter();

        player.history(name);
        options(player);
    }

    private static Player choiceCharacter() {
        int choice = 0;

        do {
            System.out.println("1. Gladiador\n2. Arqueiro\n3. Necromante");
            choice = Integer.valueOf(scanner.nextLine());
        }
        while(confirmChoice() != 1);

        switch(choice) {
            case 1:
                return new Gladiador();
            case 2:
                return new Arqueiro();
            case 3:
                return new Necromante();
            default:
                System.out.println("Personagem não encontrado");
                return null;
        }
    }

    private static int confirmChoice() {
        System.out.println("Essa é uma escolha vital, você tem certeza de sua decisão? 1. Sim // 2. Não");
        return Integer.valueOf(scanner.nextLine());
    }

    private static void tutorial() {
        System.out.println("Este jogo funciona através de escolhas. Você só precisa escolher uma ação digitando o número respectivo.");
        menu();
    }

    private static void options(Player player) {
        System.out.println("1. Ir à taverna\n2. Adentrar na Dungeon\n3. Iventário\n4. Atributos");
        int choice = Integer.valueOf(scanner.nextLine());

        switch(choice) {
            case 1:
                break;
            case 2:
                dungeon(player);
                break;
            case 3:
                break;
            case 4: {
                player.getAttributes();
                options(player);
                break;
            }
        }
    }

    private static void dungeon(Player player) {
        System.out.println("Você acaba de entrar na Dungeon, mas escuta alguns barulhos estranhos, o que deseja fazer?");
        System.out.println("1. Investigar\n2. Ignorar\n3. Sair");
        int choice = Integer.valueOf(scanner.nextLine());

        switch(choice) {
            case 1: {
                int randomNumber = (int) (Math.random() * 2);
                if(randomNumber == 1) {
                    System.out.println("Você foi investigar e entrou em desespero, o que era aquele ser na sua frente?");
                    Combat combat = new Combat();

                    String result = combat.init(player);


                    if(result == "win") {// teste
                    } else {//
                        death();//
                        return;
                    }//

                    combat = null;
                } else {
                    System.out.println("Nada foi encontrado, você decide continuar a sua jornada.");
                }

                options(player); // Apenas para testes
                break;
            }
            case 2: {
                int randomNumber = (int) (Math.random() * 2);
                if(randomNumber == 1) {
                    System.out.println("Você ignorou e foi surpreendido, algo te atacou!");
                    Combat combat = new Combat();

                    String result = combat.init(player);

                    combat = null;

                } else {
                    System.out.println("Nada foi encontrado, você decide continuar a sua jornada.");
                }

                break;
            }
            case 3: {
                System.out.println("Você fugiu covardemente, como você deveria se sentir após isso?");
                options(player);

                break;
            }
        }
    }

    private static void death() {
        scanner.close();
        System.out.println("Game Over!");
    }
}
