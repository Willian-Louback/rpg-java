package packages.player;

public class Arqueiro extends Player {
    public Arqueiro() {
        super("Arqueiro", 5, 7, 7);
    }

    public void history(String name) {
        System.out.println("Em busca de concluir uma promessa ao seu irmão, " + name + ", o " + this.getName() + ", se muda para uma cidade arrasada...");
    }
}
