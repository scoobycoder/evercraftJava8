package evercraftJava8;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HealthTest {

	private Health health;

	@Before
	public void startup() {
		health = new Health();
	}
	
	@Test
	public void shouldHaveStartingHealth() {
		assertEquals(10, health.startingHealth());
	}
	
	@Test
	public void shouldReturnHealthValue() {
		assertEquals(10, health.getValue());
	}
	
	@Test
	public void shouldAllHealthReduction() {
		health.setValue(health.getValue() - 5);
		
		assertEquals(5, health.getValue());
	}
	
}
