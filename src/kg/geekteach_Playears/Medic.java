package kg.geekteach_Playears;

public class Medic extends Hero{
    private int heallPoints;
    public Medic(int health, int damage, String name,int heallPoints) {
        super(health, damage,name,SuperAbility.HILL);// у всех воинов будет способность CRITICAL_DAMAGE
        this.heallPoints = heallPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i <heroes.length ; i++) {
           if(heroes[i].getHealth()>0 && heroes[i] != this ){
               heroes[i].setHealth(heroes[i].getHealth() + heallPoints);
           }
        }

    }
}
