package MainModules;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBoard {

	Board b;
	Snake1 s1, s2;
	Ladder l1;

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
		l1 = new Ladder(2,18);
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test1() throws Exception {
		b.addSnake(s1);
		assertEquals(b.snakes[s1.getHead()], s1);
		System.out.println("Test1");
	}

	@Test
	public void test2() throws Exception {
		b.addLadder(l1);
		assertEquals(b.ladders[l1.getStartPoint()], l1);
		System.out.println("Test2");
	}}
