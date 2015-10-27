package evercraftJava8;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpockTest{

	private static final int DEAD = 0;
	private static final int DAMAGE_OF_TWO = 2;
	private static final int NO_DAMAGE = 0;
	private static final int DAMAGE_OF_ONE = 1;

	private ClassPathXmlApplicationContext applicationContext;
	
	@Mock
	private RollingDice mockedDice;
	@Mock
	private CraftCharacter mockedOpponent;
	@Mock
	private Armor mockedArmor;
	@Mock
	private Puzzle mockedPuzzle;
	@Mock
	private Joke mockedJoke;

	@InjectMocks
	private Spock underTest;


	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (Spock) applicationContext.getBean("spock");
	}
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void spockKnowsHisName() {
		assertEquals("Spock", underTest.getName());
	}
	
	@Test
	public void spockWillNotAttackCharacterWithNoArmorIfHeIsGood() {
		when(mockedDice.roll()).thenReturn(10);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(0);
		
		underTest.attack(mockedDice, mockedOpponent);
		
		assertEquals(false, underTest.attack(mockedDice, mockedOpponent));
	}
	
	
	@Test
	public void sometimesSpockGoesToMirrorUniverseAndIsEvilOnly() {
		underTest.setGood(0);
		underTest.setEvil(1000);
		underTest.setNeutral(1);
		
		assertEquals(1000, underTest.getEvil());
		assertEquals(1, underTest.getNeutral());
	}
	
	@Test
	public void spockHasArmorWhenHePlaysAGladiator() {
		assertEquals(10, underTest.getArmorLevel());
		assertEquals(5, underTest.getArmorHitPoints());
	}
	
	@Test
	public void spockCanRollToAttack() {
		when(mockedArmor.getArmor()).thenReturn(20);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		
		underTest.attack(mockedDice, mockedOpponent);
	
		verify(mockedDice).roll();
	}
	
	@Test
	public void spockRollsa20ToHitOpponent() {
		when(mockedDice.roll()).thenReturn(20);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(10);
	
		underTest.attack(mockedDice, mockedOpponent);
		
		assertEquals(true, underTest.attack(mockedDice, mockedOpponent));
	}
	
	@Test
	public void spockRollsa10FailsToHitOpponent() {
		when(mockedDice.roll()).thenReturn(10);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(20);
		
		underTest.attack(mockedDice, mockedOpponent);
		
		assertEquals(false, underTest.attack(mockedDice, mockedOpponent));
	}
	
	@Test
	public void spockTakesHitAndSuffersDamage() {
		when(mockedDice.roll()).thenReturn(15);
		when(mockedArmor.getArmor()).thenReturn(10);
		
		assertEquals(DAMAGE_OF_ONE, underTest.isAttacked(mockedDice));
	}
	
	@Test
	public void spockTakesHitAndSuffersNoDamage() {
		when(mockedDice.roll()).thenReturn(5);
		when(mockedArmor.getArmor()).thenReturn(10);
		
		assertEquals(NO_DAMAGE, underTest.isAttacked(mockedDice));
	}
	
	@Test
	public void spockTakesDoubleDamageFromRollOf20() {
		when(mockedDice.roll()).thenReturn(20);
		
		assertEquals(DAMAGE_OF_TWO, underTest.isAttacked(mockedDice));
	}
	
	@Test
	public void whenSpockRunsOutOfHealthHeDies() {
		when(mockedDice.roll()).thenReturn(20);
		attackedTimes(mockedDice, 5);
		
		assertEquals(DEAD, underTest.getHealth());
	}
	
	@Test
	public void spockCanCompleteDifficultPuzzles() {
		when(mockedPuzzle.difficulty()).thenReturn(19);
		
		assertThat(underTest.completePuzzle(mockedPuzzle), is("Success"));
	}
	
	@Test
	public void spockCannotTellAJoke() {
		when(mockedJoke.difficulty()).thenReturn(5);
		
		assertThat(underTest.jokeCreatesLaughs(mockedJoke), is("Failure"));
	}

	private void attackedTimes(RollingDice dice, int times) {
		for (int i = 0; i < times; i++)
			underTest.isAttacked(dice);
	}
	
}
