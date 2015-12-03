package evercraftJava8;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbilitiesTest {

	private ClassPathXmlApplicationContext applicationContext;
	
	@InjectMocks
	private Abilities underTest;
	
	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (Abilities) applicationContext.getBean("abilities");
	}
	
	@Test
	public void abilitiesShouldIncludeAllAbilities() {
		assertThat(underTest.getCharisma(), is(5));
		assertThat(underTest.getIntelligence(), is(20));
		assertThat(underTest.getStrength(), is(20));
		assertThat(underTest.getDexterity(), is(15));
		assertThat(underTest.getConstitution(), is(18));
	}
	
}
