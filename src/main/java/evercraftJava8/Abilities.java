package evercraftJava8;

public class Abilities {

	private Ability intelligence;
	private Ability charisma;
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;

	public Abilities(Ability intelligence, Ability charisma, Ability strength, Ability dexterity, Ability constitution) {
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
	}
	
	public int getIntelligence() {
		return intelligence.getLevel();
	}
	
	public int getCharisma() {
		return charisma.getLevel();
	}

	public int getStrength() {
		return strength.getLevel();
	}

	public int getDexterity() {
		return dexterity.getLevel();
	}

	public int getConstitution() {
		return constitution.getLevel();
	}
	
}
