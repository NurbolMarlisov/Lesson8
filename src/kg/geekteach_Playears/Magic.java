package kg.geekteach_Playears;

import kg.geektech_general.RPG_Game;

public class Magic extends Hero{
    public Magic(int health, int damage,String name) {
        super(health, damage,name,SuperAbility.BOOST);// у всех воинов будет способность CRITICAL_DAMAGE
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int boost = RPG_Game.random.nextInt(6) + 5; //5,6,7,8,9,10
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getDamage() > 0) {
                heroes[i].setDamage(heroes[i].getDamage() + boost);
            }

        }
        System.out.println( " Маг увеличил урон всех героев");
    }}

