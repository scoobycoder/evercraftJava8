package evercraftJava8;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OpponentTest {

	@Mock
	private RollingDice mockedDice;
	@Mock
	private Armor mockedArmor;
	@Mock
	private Modifier mockModifier;
	@Spy @InjectMocks
	private Spock spock;
	
	private AnnotationConfigApplicationContext applicationContext;
	private CraftCharacter underTest;
	
	@Before
	public void setup() {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		underTest = (CraftCharacter) applicationContext.getBean("craftCharacter");
		spock = (Spock) applicationContext.getBean("spock");
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void spockWillApplyStrengthModifierWhenHeAttacksOpponent() {
		// This is turned off while I switch to Spring Annotations so that I can figure out how
		// to inject a mock in for modifier
		when(mockedDice.roll()).thenReturn(15);
		when(mockModifier.modify(15)).thenReturn(17);
		when(mockedArmor.getArmor()).thenReturn(10);
		
		spock.attack(mockedDice, underTest);
		
		assertThat(underTest.getHealth(), is(8));
	}
	
}
