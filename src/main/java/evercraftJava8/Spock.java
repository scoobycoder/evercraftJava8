package evercraftJava8;

public class Spock extends CraftCharacter implements Alignment {
	private String name = "Spock";
	private int evil = 0;
	private int good = 1000;
	private int neutral = 0;
	private Armor armor;
	private Health health;
	private Abilities abilities;

	public Spock(Armor armor, Health startingHealth, Abilities abilities) {
		super(armor, startingHealth);
		this.armor = armor;
		this.health = startingHealth;
		this.abilities = abilities;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean attack(RollingDice dice, CraftCharacter opponent) {
		if (opponent.getArmor().getArmor() <= 0 && good > evil)
			return false;
		
		return dice.roll() > opponent.getArmor().getArmor();
	}

	@Override
	public int getNeutral() {
		return neutral;
	}

	@Override
	public void setGood(int newGood) {
		good = newGood;
	}

	@Override
	public void setEvil(int newEvil) {
		evil = newEvil;
	}

	@Override
	public void setNeutral(int newNeutral) {
		neutral = newNeutral;
	}

	public int getArmorLevel() {
		return armor.getArmor();
	}

	public int getArmorHitPoints() {
		return armor.getArmorHitPoints();
	}

	public int getHealth() {
		return health.getValue();
	}

	public String completePuzzle(Puzzle puzzle) {
		String result = "Failure";
		
		if (abilities.getIntelligence() > puzzle.difficulty())
			result = "Success";
		
		return result;
	}

	public String jokeCreatesLaughs(Joke joke) {
		String result = "Failure";
		
		if (abilities.getCharisma() > joke.difficulty())
			result = "Success";

		return result;
	}

}
