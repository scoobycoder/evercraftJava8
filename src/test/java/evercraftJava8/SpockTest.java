package evercraftJava8;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
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
	@Mock
	private Loan loan;
	@Mock
	private Virus virus;
	@Mock
	private Yarn yarn;
	@Mock
	private WashCloth washCloth;

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
	public void spockCanApplyForLoan() {
		underTest.apply(loan);
		verify(loan).submit("Spock");
	}
	
	@Test
	public void spockWillNotAttackCharacterWithNoArmorIfHeIsGood() {
		when(mockedDice.roll()).thenReturn(10);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(0);
		
		underTest.attack(mockedDice, mockedOpponent);
		
		assertThat(underTest.attack(mockedDice, mockedOpponent), is(false));
	}
	
	@Test
	public void whenSpockIsInMirrorUniverseHeWillAttackCharacterWithNoArmor() {
		underTest = (Spock) applicationContext.getBean("evilSpock");
		when(mockedDice.roll()).thenReturn(10);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(0);
		
		underTest.attack(mockedDice, mockedOpponent);
		
		assertThat(underTest.attack(mockedDice, mockedOpponent), is(true));
	}
	
	@Test
	public void spockHasArmorWhenHePlaysAGladiator() {
		assertThat(underTest.getArmorLevel(), is(10));
		assertThat(underTest.getArmorHitPoints(), is(5));
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
		
		assertThat(underTest.attack(mockedDice, mockedOpponent), is(true));
	}
	
	@Test
	public void spockRollsa10FailsToHitOpponent() {
		when(mockedDice.roll()).thenReturn(10);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(20);
		
		underTest.attack(mockedDice, mockedOpponent);
		
		assertThat(underTest.attack(mockedDice, mockedOpponent), is(false));
	}
	
	@Test
	public void spockTakesHitAndSuffersDamage() {
		when(mockedDice.roll()).thenReturn(15);
		when(mockedArmor.getArmor()).thenReturn(10);
		
		assertThat(underTest.isAttacked(mockedDice), is(DAMAGE_OF_ONE));
	}
	
	@Test
	public void spockTakesHitAndSuffersNoDamage() {
		when(mockedDice.roll()).thenReturn(5);
		when(mockedArmor.getArmor()).thenReturn(10);
		
		assertThat(underTest.isAttacked(mockedDice), is(NO_DAMAGE));
	}
	
	@Test
	public void spockTakesDoubleDamageFromRollOf20() {
		when(mockedDice.roll()).thenReturn(20);
		
		assertThat(underTest.isAttacked(mockedDice), is(DAMAGE_OF_TWO));
	}
	
	@Test
	public void whenSpockRunsOutOfHealthHeDies() {
		when(mockedDice.roll()).thenReturn(20);
		attackedTimes(mockedDice, 5);
		
		assertThat(underTest.getHealth(), is(DEAD));
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
	
	@Test
	public void spockIsWiseAndWillNotFightCharactersWithMaxHealthAndArmor() {
		when(mockedOpponent.getHealth()).thenReturn(20);
		when(mockedOpponent.getArmor()).thenReturn(mockedArmor);
		when(mockedArmor.getArmor()).thenReturn(20);
		
		assertThat("Spock did not run when he should have ran.", underTest.willRun(mockedOpponent), is(true));
	}
	
	@Test
	public void spockCannotCatchTheCold() {
		when(virus.getName()).thenReturn("cold");
		
		assertThat("Spock caught the cold, but he shouldn't", underTest.isSick(virus), is(false));
	}
	
	@Test
	public void spockCanCatchTheVulcanVirus() {
		when(virus.getName()).thenReturn("vulcan virus");
		
		assertThat("Spock did not catch the Vulcan Virus but he should.", underTest.isSick(virus), is(true));
	}
	
	@Test
	public void spockCanKnitAWashCloth() {
		when(yarn.getAmount()).thenReturn(2);
		
		assertThat("Spock should be able to knit a wash cloth", underTest.knit(yarn), isA(KnittedItem.class));
	}

	private void attackedTimes(RollingDice dice, int times) {
		for (int i = 0; i < times; i++)
			underTest.isAttacked(dice);
	}
	
}
