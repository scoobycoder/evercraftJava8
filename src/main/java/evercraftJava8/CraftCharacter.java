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
	
	public boolean isAttacked(RollingDice dice) {
		return dice.roll() > armor.getArmor();
	}
	
}
