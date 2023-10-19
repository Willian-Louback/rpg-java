package packages.player;

public class Necromante extends Player {
    public Necromante() {
        super("Necromante", 3, 9, 8);
    }

    public void history(String name) {
        System.out.println("Em busca de mais poder, " + name + ", o " + this.getName() + ", se muda para uma cidade arrasada...");
    }
}
