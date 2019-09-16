package MainModules;



public class Test {
	Board b;
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Test t = new Test();
		System.out.println("After Test");
	}

	public Test() throws Exception
	{
		b = new Board();
		Snake1 s = new Snake1(9,6);
		Snake1 s1 = new Snake1(9,6);
		Ladder l1 = new Ladder(2,30);
		//Ladder l2 = new Ladder(7,31);
		try
		{
			b.addSnake(s);
			b.addLadder(l1);
			System.out.println("After addSnake()");
			b.addSnake(s1);
			//b.addLadder(l2);
			System.out.println("After addSnake()");
		}
		catch(SnakePlacementException spe)
		{
			spe.printStackTrace();
			System.out.println("Exception Handled by SnakePlacementException catch");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception Handled by Exception catch");			
		}
		finally
		{
			System.out.println("Finally");
		}
	}
}
