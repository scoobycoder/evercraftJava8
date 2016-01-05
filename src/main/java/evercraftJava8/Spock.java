package evercraftJava8;

import org.springframework.beans.factory.annotation.Autowired;

public class Spock extends CraftCharacter {
	private String name = "Spock";
	private Armor armor;
	private Health health;
	private Abilities abilities;
	private Alignment alignment;
	private KnittingFactory knittingFactory;
	private Modifier modifier;

	@Autowired
	public Spock(Armor armor, Health startingHealth, Abilities abilities, Alignment alignment, KnittingFactory knittingFactory, Modifier modifier) {
		super(armor, startingHealth, modifier);
		this.armor = armor;
		this.health = startingHealth;
		this.abilities = abilities;
		this.alignment = alignment;
		this.knittingFactory = knittingFactory;
		this.modifier = modifier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void attack(RollingDice dice, CraftCharacter opponent) {
		if (opponent.getArmor().getArmor() <= 0 && alignment.getGood() > alignment.getEvil()) {
			
		}
		
		if (modifyRoll(dice.roll()) > opponent.getArmor().getArmor()) {
			opponent.isAttacked(dice);
		}
	}

	private int modifyRoll(int roll) {
		return modifier.modify(roll);
	}

	public int getArmorLevel() {
		return armor.getArmor();
	}

	public int getArmorHitPoints() {
		return armor.getArmorHitPoints();
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

	public void apply(Loan loan) {
		loan.submit(name);
	}

	public boolean willRun(CraftCharacter opponent) {
		boolean willRun = false;
		
		if (opponent.getHealth() >= 20 && opponent.getArmor().getArmor() >= 20)
			willRun = true;
		
		return willRun;
	}

	public boolean isSick(Virus virus) {
		boolean sick = false;
		
		if (virus.getName() == "vulcan virus")
			sick = true;
		
		return sick;
	}

	public KnittedItem knit(Yarn yarn) {
		KnittedItem knittedItem = knittingFactory.knit(yarn);
		
		return knittedItem;
	}

}
