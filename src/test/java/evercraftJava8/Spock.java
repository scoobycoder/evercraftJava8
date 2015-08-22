package evercraftJava8;

public class Spock extends CraftCharacter implements Alignment {
	private String name = "Spock";
	private int evil = 0;
	private int good = 1000;
	private int neutral = 0;
	
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

	
}
