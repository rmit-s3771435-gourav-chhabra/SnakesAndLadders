package MainModules;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSnakeController {

	Board b;
	Snake1 s1, s2;
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
		s1 = new Snake1(9, 2);
		s2 = new Snake1(10, 3);
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test1() throws Exception {
		Snake1 s = new Snake1(24, 1);
		assertEquals(s.getHead(), 24);
		b.addSnake(s);
		b.moveSnake("right", s);
		assertEquals(s.getHead(), 25);
	}

	@Test
	public void test2() throws Exception {
		Snake1 s = new Snake1(24, 1);
		assertEquals(s.getHead(), 24);
		b.addSnake(s);
		b.moveSnake("Up", s);
		assertEquals(s.getHead(), 37);
	}

	@Test(expected = Exception.class)
	public void test3() throws Exception {
		Snake1 s = new Snake1(2, 1);
		assertEquals(s.getHead(), 2);
		b.addSnake(s);
		b.moveSnake("down", s);
	}

	@Test(expected = Exception.class)
	public void test4() throws Exception {
		Snake1 s = new Snake1(98, 1);
		assertEquals(s.getHead(), 98);
		b.addSnake(s);
		b.moveSnake("up", s);
	}

	@Test
	public void test5() throws Exception {
		Snake1 s = new Snake1(24, 1);
		assertEquals(s.getHead(), 24);
		b.addSnake(s);
		b.moveSnake("down", s);
		assertEquals(s.getHead(), 17);
	}

	@Test
	public void test6() throws Exception {
		Snake1 s = new Snake1(24, 1);
		assertEquals(s.getHead(), 24);
		b.addSnake(s);
		b.moveSnake("left", s);
		assertEquals(s.getHead(), 23);
	}

	@Test(expected = Exception.class)
	public void test7() throws Exception {
		assertEquals(s1.getHead(), 9);
		assertEquals(s2.getHead(), 10);
		b.addSnake(s1);
		b.addSnake(s2);
		b.moveSnake("right", s1);
		assertEquals(s1.getHead(), 10);
	}

	@Test(expected = Exception.class)
	public void test8() throws Exception {
		s1 = new Snake1(81, 71);
		s2 = new Snake1(79, 1);
		b.addSnake(s1);
		b.addSnake(s2);
		b.moveSnake("UP", s2);
		assertEquals(s2.getHead(), 82);
	}

	@Test
	public void test9() throws Exception {
		s1 = new Snake1(61, 51);
		s2 = new Snake1(79, 59);
		b.addSnake(s1);
		b.addSnake(s2);
		b.moveSnake("UP", s2);
		assertEquals(s2.getHead(), 82);
	}

}