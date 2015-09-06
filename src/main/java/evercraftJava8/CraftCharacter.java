package evercraftJava8;

public class CraftCharacter {
	private String name = "Name";
	private Armor armor;

	public CraftCharacter(Armor armor) {
		this.setArmor(armor);
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
		if (hasBonusDamage(dice))
			return 2;
		
		if (rollGreaterThanArmor(dice))
			return 1;
		
		return 0;
	}

	private boolean rollGreaterThanArmor(RollingDice dice) {
		return dice.roll() > armor.getArmor();
	}

	private boolean hasBonusDamage(RollingDice dice) {
		return dice.roll() == 20;
	}
	
}
