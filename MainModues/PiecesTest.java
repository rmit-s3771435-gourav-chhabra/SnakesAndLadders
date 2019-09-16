package MainModules;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PiecesTest {

	Board b;
	Pieces p;

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
		p = new Pieces();
		b = new Board();
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test1() {
		b.addPiece();
		int pos = b.p.get(0).getPos();
		assertEquals(pos, 1);
	}

	@Test
	public void test2() {
		b.addPiece();
		int pos = b.p.get(0).getPos();
		assertEquals(pos, 1);
		b.p.get(0).movePiece();
		int newPos = b.p.get(0).getPos();
		System.out.println(newPos);
		assertNotEquals(pos, newPos);
	}

	@Test
	public void test3() {
		b.addPiece();
		int pos = b.p.get(0).getPos();
		assertEquals(pos, 1);
		b.p.get(0).movePiece();
		int newPos = b.p.get(0).getPos();
		assertTrue((newPos - pos) <= 6);
	}

}