package evercraftJava8;

public class Abilities {

	private Ability intelligence;
	private Ability charisma;
	private Ability strength;

	public Abilities(Ability intelligence, Ability charisma, Ability strength) {
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.strength = strength;
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
	
}
