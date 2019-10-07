package MainModules;

import graphics.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLadder {

	graphics.Board b;
	Ladder l1, l2, l3, l4, l5, l6, l7;
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
		l1 = new Ladder(2, 30);
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test1() throws Exception {
		b.add(l1);
		assertEquals(b.ladders[l1.getStartPoint()], l1);
		System.out.println("Test1");
	}

	@Test(expected = Exception.class)
	public void test2() throws Exception {
		l3 = new Ladder(8, 39);
		b.add(l3);
	}
	
	@Test
	public void test6() throws Exception {
		l2 = new Ladder(7, 37);
		b.add(l2);
	}
	
	@Test(expected = Exception.class)
	public void test3() throws Exception {
		Snake1 s = new Snake1(40,22);
		l2 = new Ladder(40, 54);
		b.add(s);
		b.add(l2);

	}
	
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		l2 = new Ladder(40, 54);
		l3 = new Ladder(41, 54);
		l4 = new Ladder(42, 54);
		l5 = new Ladder(43, 54);
		l6 = new Ladder(45, 54);
		l7 = new Ladder(46, 54);
		
		b.add(l2);
		b.add(l3);
		b.add(l4);
		b.add(l5);
		b.add(l6);
		b.add(l7);
	}
	
	@Test
	public void test5() throws Exception {
		l2 = new Ladder(40, 54);
		l3 = new Ladder(41, 54);
		l4 = new Ladder(42, 54);
		l5 = new Ladder(43, 54);
		l6 = new Ladder(45, 54);
		
		b.add(l2);
		b.add(l3);
		b.add(l4);
		b.add(l5);
		b.add(l6);
	}

}
