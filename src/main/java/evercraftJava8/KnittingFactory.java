package evercraftJava8;

public class KnittingFactory {

	public KnittedItem knit(Yarn yarn) {
		KnittedItem knitted = new KnittedItem();
		
		if (yarn.getAmount() > 5)
			knitted.type = "wash cloth";
			
		return knitted;
	}

}
