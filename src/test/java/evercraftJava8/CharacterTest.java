package evercraftJava8;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CharacterTest {
	private ClassPathXmlApplicationContext applicationContext;
	private CraftCharacter underTest;

	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (CraftCharacter) applicationContext.getBean("craftCharacter");
	}
	
	@Test
	public void characterShouldTellItsName() {
		assertThat(underTest.getName(), is("Name"));
	}
	
	
}
