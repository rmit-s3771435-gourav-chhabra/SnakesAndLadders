package MainModules;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class junittests {

	Board b;
	Snake1 s1, s2;

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
		s1 = new Snake1(9, 2);
		s2 = new Snake1(10, 3);
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test1() throws SnakePlacementException {
		b.addSnake(s1);
		assertEquals(b.snakes[s1.getHead()], s1);
		System.out.println("Test1");
	}

	@Test
	public void test2() throws SnakePlacementException {
		b.addSnake(s1);
		assertEquals(b.snakes[s1.getHead()], s1);
		b.addSnake(s2);
		assertEquals(b.snakes[s2.getHead()], s2);
		System.out.println("Test2");
	}

	@Test(expected = SnakePlacementException.class)
	public void test3() throws SnakePlacementException, Exception {
		b.addSnake(s1);
		s2 = new Snake1(s1.getHead(), s1.getTail());
		b.addSnake(s2);
		System.out.println("Test3");
	}

	@Test
	public void test4() throws Exception {
		// mostly useless test
		// what is it testing? the constructor and a getter
		Snake1 s = new Snake1(2, 1);
		assertEquals(s.getHead(), 2);
	}

	@Test
	public void test5() throws SnakePlacementException, Exception {
		// Incomplete test (not precondition testing)
		Snake1 s = new Snake1(2, 1);
		b.addSnake(s);
		assertEquals(s.getHead(), 2);
		assertTrue(b.snakes[s.getHead()] == s);
	}

}
