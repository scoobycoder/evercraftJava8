package evercraftJava8;

public class CraftCharacter {
	private String name = "Name";
	private Armor armor;
	private Health health;
	private Modifier modifier;

	public CraftCharacter(Armor armor, Health startingHealth, Modifier modifier) {
		this.setArmor(armor);
		this.health = startingHealth;
		this.modifier = modifier;
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

	public int getHealth() {
		return health.getValue();
	}

	public void attack(RollingDice dice, CraftCharacter opponent) {
		if (dice.roll() > opponent.getArmor().getArmor()) 
			opponent.isAttacked(dice);
	}

	public void isAttacked(RollingDice dice) {

		if (rollGreaterThanArmor(dice)) {
			handleRegularDamage();
			handleBonusDamage(dice);
		}

	}

	private void handleRegularDamage() {
		this.health.setValue(health.getValue() - 1);
	}

	private void handleBonusDamage(RollingDice dice) {
		if (hasBonusDamage(dice))
			handleRegularDamage();
	}

	private boolean rollGreaterThanArmor(RollingDice dice) {
		int bonusArmor = 0;

		bonusArmor = modifier.modify(armor.getArmor());

		return dice.roll() > (armor.getArmor() + bonusArmor);
	}

	private boolean hasBonusDamage(RollingDice dice) {
		return dice.roll() == 20;
	}

}
