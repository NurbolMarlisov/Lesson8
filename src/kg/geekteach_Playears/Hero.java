package kg.geekteach_Playears;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
private SuperAbility ability;

    public SuperAbility getAbility() {
        return ability;
    }
    public void attack(Boss boss){
        if (/*this.getHealth()>0 &&*/ boss.getHealth()>0)
        boss.setHealth(boss.getHealth() - this.getDamage());

    }

    public Hero(int health, int damage, String name, SuperAbility ability) {
        super(health, damage,name);
        this.ability = ability;
    }
}
