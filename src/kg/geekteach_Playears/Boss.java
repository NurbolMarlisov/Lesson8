package kg.geekteach_Playears;

import kg.geektech_general.RPG_Game;

public class Boss extends GameEntity {


    public Boss(int health, int damage, String name) {
        super(health, damage, name);

    }

    private SuperAbility defence;

    public void choosDefence(Hero[] heroes) {
   int randomIndex = RPG_Game.random.nextInt(heroes.length);
   this.defence =  heroes[randomIndex].getAbility();
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() >0)
            heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
        }
    }

    public String toString() {
        return "Boss " + super.toString() + " Defence " +
                (this.getDefence() == null ? " No defence " : this.getDefence());
    }

    public SuperAbility getDefence() {
        return defence;
    }
}
