package evercraftJava8;

public class Spock extends CraftCharacter implements Alignment{
	private String name = "Spock";
	private int evil = 0;
	private int good = 1000;
	private int neutral = 0;
	private Armor armor;
	private Health health;
	
	public Spock(Armor armor, Health startingHealth) {
		super(armor, startingHealth);
		this.armor = armor;
		this.health = startingHealth;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getEvil() {
		return evil;
	}
	
	@Override
	public int getGood() {
		return good;
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
	
}
