package evercraftJava8;

public class Intelligence implements Ability {

	private int level;
	private String abilityName;

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String getAbilityName() {
		return abilityName;
	}

	@Override
	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}

}
