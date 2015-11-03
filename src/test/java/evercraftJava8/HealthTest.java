package evercraftJava8;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HealthTest {

	private Health health;

	@Before
	public void startup() {
		health = new Health();
	}
	
	@Test
	public void shouldHaveStartingHealth() {
		assertThat(health.startingHealth(), is(10));
	}
	
	@Test
	public void shouldReturnHealthValue() {
		assertThat(health.getValue(), is(10));
	}
	
	@Test
	public void shouldAllHealthReduction() {
		health.setValue(health.getValue() - 5);
		
		assertThat(health.getValue(), is(5));
	}
	
}
