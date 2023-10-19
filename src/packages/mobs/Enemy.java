package packages.mobs;

import packages.player.Player;

public abstract class Enemy {
    private String name;
    private int maxLife;
    private int life;
    private int shield;
    private int attack;

    protected Enemy(String name, int life, int shield, int attack) {
        this.name = name;
        this.maxLife = life;
        this.life = life;
        this.shield = shield;
        this.attack = attack;
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public int getShield() {
        return this.shield;
    }

    public boolean hit(Player player) {
        attack();

        int currentLife = player.getLife() - this.attack;
        player.setLife(currentLife);

        if(currentLife <= 0) {
            System.out.println("Jogador derrotado!");
            return true;
        } else {
            System.out.println("O jogador sofreu " + this.attack + " de dano. Sua vida agora é " + player.getLife() + "/" + player.getMaxLife());
            return false;
        }
    }

    public abstract void attack();
}
