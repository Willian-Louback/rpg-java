package packages.player;

public class Gladiador extends Player {
    public Gladiador() {
        super("Gladiador", 8, 5, 1);
    }

    public void history(String name) {
        System.out.println("Em busca de mais batalhas, " + name + ", o " + this.getName() +", se muda para uma cidade arrasada...");
    }
}
