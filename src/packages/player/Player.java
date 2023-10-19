package packages.player;

import packages.mobs.Enemy;

public abstract class Player {
    private String name;
    private int maxLife;
    private int life;
    private int shield;
    private int attack;

    protected Player(String name, int life, int shield, int attack) {
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

    public void getAttributes() {
        System.out.println(
            "Vida: " + this.life + "/" + this.maxLife +
            "\nEscudo: " + this.shield +
            "\nDano: " + this.attack
        );
    }

    public boolean hit(Enemy enemy) {
        int currentLife = enemy.getLife() - this.attack;
        enemy.setLife(currentLife);

        if(currentLife <= 0) {
            System.out.println("Inimigo derrotado!");
            return true;
        } else {
            System.out.println("O inimigo sofreu " + this.attack + " de dano. A vida do inimigo agora é " + enemy.getLife() + "/" + enemy.getMaxLife());
            return false;
        }
    }

    public abstract void history(String name);
}
