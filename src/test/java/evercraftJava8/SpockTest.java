package evercraftJava8;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.mockito.Mockito.when;


public class SpockTest{

	private ClassPathXmlApplicationContext applicationContext;
	
	@Mock
	private RollingDice mockedDice;
	@Mock
	private CraftCharacter mockedOpponent;
	@Mock
	private Armor mockedArmor;

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
	public void spockIsOnlyGood() {
		assertEquals(1000, underTest.getGood());
		assertEquals(0, underTest.getEvil());
	}
	
	@Test
	public void sometimesSpockGoesToMirrorUniverseAndIsEvilOnly() {
		underTest.setGood(0);
		underTest.setEvil(1000);
		underTest.setNeutral(1);
		
		assertEquals(0, underTest.getGood());
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
	
}
