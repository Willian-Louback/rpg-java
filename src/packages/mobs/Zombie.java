package packages.mobs;

public class Zombie extends Enemy{
    public Zombie() {
        super("Zombie", 5, 4, 2);
    }

    public void attack() {
        System.out.println("O " + this.getName() + " te mordeu com força.");
    }
}
