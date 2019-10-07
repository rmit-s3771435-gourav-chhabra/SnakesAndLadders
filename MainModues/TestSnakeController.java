package MainModules;

import graphics.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSnakeController {

	graphics.Board b;
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
		b = new graphics.Board();
		sc = new SnakeController();
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
		b.add(s);
		sc.moveSnake(b, "right", s);
		assertEquals(s.getHead(), 25);
	}

	@Test
	public void test2() throws Exception {
		Snake1 s = new Snake1(24, 1);
		assertEquals(s.getHead(), 24);
		b.add(s);
		sc.moveSnake(b, "Up", s);
		assertEquals(s.getHead(), 37);
	}

	@Test(expected = Exception.class)
	public void test3() throws Exception {
		Snake1 s = new Snake1(2, 1);
		assertEquals(s.getHead(), 2);
		b.add(s);
		sc.moveSnake(b, "down", s);
		
	}

	@Test(expected = Exception.class)
	public void test4() throws Exception {
		Snake1 s = new Snake1(98, 88);
		assertEquals(s.getHead(), 98);
		b.add(s);
		sc.moveSnake(b, "up", s);
	}

	@Test(expected = Exception.class)
	public void test5() throws Exception {
		Snake1 s = new Snake1(24, 1);
		assertEquals(s.getHead(), 24);
		b.add(s);
		sc.moveSnake(b, "down", s);
		assertEquals(s.getHead(), 17);
	}

//	@Test(expected = Exception.class)
//	public void test6() throws Exception {
//		Snake1 s = new Snake1(24, 1);
//		assertEquals(s.getHead(), 24);
//		b.add(s);
//		sc.moveSnake(b, "left", s);
//		assertEquals(s.getHead(), 23);
//	}

	@Test(expected = Exception.class)
	public void test7() throws Exception {
		assertEquals(s1.getHead(), 9);
		assertEquals(s2.getHead(), 10);
		b.add(s1);
		b.add(s2);
		sc.moveSnake(b, "right", s1);
		assertEquals(s1.getHead(), 10);
	}

	@Test(expected = Exception.class)
	public void test8() throws Exception {
		s1 = new Snake1(81, 71);
		s2 = new Snake1(79, 1);
		b.add(s1);
		b.add(s2);
		sc.moveSnake(b, "UP", s2);
		assertEquals(s2.getHead(), 82);
	}

	@Test
	public void test9() throws Exception {
		s1 = new Snake1(61, 51);
		s2 = new Snake1(79, 59);
		b.add(s1);
		b.add(s2);
		sc.moveSnake(b, "UP", s2);
		assertEquals(s2.getHead(), 82);
	}
	
	@Test
	public void test10() throws Exception {
		s1 = new Snake1(61, 51);
		b.add(s1);
		int oldLength = s1.getLength();
		sc.moveSnake(b, "UP", s1);
		int newLength = s1.getLength();
		assertEquals(oldLength, newLength);
	}

}