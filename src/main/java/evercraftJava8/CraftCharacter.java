package evercraftJava8;

public class CraftCharacter {
	private String name = "Name";
	private Armor armor;
	private Health health;

	public CraftCharacter(Armor armor, Health startingHealth) {
		this.setArmor(armor);
		this.health = startingHealth;
	}
	
	public String getName() {
		return name;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	public boolean attack(RollingDice dice, CraftCharacter opponent) {
		return dice.roll() > opponent.getArmor().getArmor();
	}
	
	public int isAttacked(RollingDice dice) {
		if (hasBonusDamage(dice)){
			this.health.setValue(health.getValue() - 2);
			return 2;
		}
		
		if (rollGreaterThanArmor(dice)) {
			this.health.setValue(health.getValue() - 1);
			return 1;
		}
		
		return 0;
	}

	private boolean rollGreaterThanArmor(RollingDice dice) {
		return dice.roll() > armor.getArmor();
	}

	private boolean hasBonusDamage(RollingDice dice) {
		return dice.roll() == 20;
	}
	
}
