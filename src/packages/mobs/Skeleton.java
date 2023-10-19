package packages.mobs;

public class Skeleton extends Enemy {
    public Skeleton() {
        super("Skeleton", 7, 4, 2);
    }

    public void attack() {
        System.out.println("O " + this.getName() + " acertou você com uma flecha.");
    }

}
