package evercraftJava8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlignmentTest {

	private ClassPathXmlApplicationContext applicationContext;
	private Alignment underTest;

	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		underTest = (Alignment) applicationContext.getBean("alignment");
	}
	
	@Test
	public void shouldReturnCurrentAlignmentValue() {
		assertEquals(200, underTest.getGood());
	}
	
}
