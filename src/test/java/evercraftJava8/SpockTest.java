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
	
}
