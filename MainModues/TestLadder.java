package MainModules;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLadder {

	Board b;
	Ladder l1, l2;
	SnakeController sc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		b = new Board();
		l1 = new Ladder(2, 30);
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test1() throws Exception {
		b.addLadder(l1);
		assertEquals(b.ladders[l1.getStartPoint()], l1);
		System.out.println("Test1");
	}

	@Test(expected = Exception.class)
	public void test11() throws Exception {
		l2 = new Ladder(7, 40);

	}

}
