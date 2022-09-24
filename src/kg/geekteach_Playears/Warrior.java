package kg.geekteach_Playears;

import kg.geektech_general.RPG_Game;

public class Warrior extends Hero{
    public Warrior(int health, int damage,String name) {
        super(health, damage,name,SuperAbility.CRITICAL_DAMAGE);// у всех воинов будет способность CRITICAL_DAMAGE
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(2)+2;
        boss.setHealth(boss.getHealth() - this.getDamage()*coeff);
        System.out.println(" Warrior hits critical damage "+ this.getDamage()*coeff);

    }
}
