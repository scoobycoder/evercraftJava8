package evercraftJava8;

public class Alignment {

	private int good;
	private int evil;
	private int neutral;
	
	public Alignment(int good, int evil, int neutral) {
		this.good = good;
		this.evil = evil;
		this.neutral = neutral;
	}
	
	public int getGood() {
		return good;
	}
	
	public int getEvil() {
		return evil;
	}
}
