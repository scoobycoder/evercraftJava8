package evercraftJava8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpockTest{

	private ClassPathXmlApplicationContext applicationContext;
	private Spock underTest;

	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (Spock) applicationContext.getBean("spock");
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
	
}
