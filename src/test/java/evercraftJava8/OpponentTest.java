package evercraftJava8;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OpponentTest {

	@Mock
	private RollingDice mockedDice;
	@Mock
	private Armor mockedArmor;
	@Mock
	private Modifier mockModifier;
	@Spy
	private Spock spock;
	
	private ClassPathXmlApplicationContext applicationContext;
	private CraftCharacter underTest;
	
	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (CraftCharacter) applicationContext.getBean("craftCharacter");
		spock = (Spock) applicationContext.getBean("spock");
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void spockWillApplyStrengthModifierWhenHeAttacksOpponent() {
		when(mockedDice.roll()).thenReturn(15);
		when(mockModifier.modify(15)).thenReturn(17);
		
		spock.attack(mockedDice, underTest);
		
		assertThat(underTest.getHealth(), is(8));
	}
	
}
