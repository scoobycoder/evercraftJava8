package evercraftJava8;

public class Abilities {

	private Ability intelligence;
	private Ability charisma;

	public Abilities(Ability intelligence, Ability charisma) {
		this.intelligence = intelligence;
		this.charisma = charisma;
	}
	
	public int getIntelligence() {
		return intelligence.getLevel();
	}
	
	public int getCharisma() {
		return charisma.getLevel();
	}
	
}
