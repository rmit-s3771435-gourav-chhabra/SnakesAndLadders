package MainModules;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) throws SnakePlacementException, Exception {
		// TODO Auto-generated method stub
		Board b = new Board();
		Scanner console = new Scanner(System.in);
		int snakeHead = 0;

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter the head position of the" + (i + 1) + "snake:");
			int head = console.nextInt();
			snakeHead = head;
			System.out.println("Enter the tail position of the" + (i + 1) + "snake:");
			int tail = console.nextInt();
			b.addSnake(new Snake1(head, tail));
		}

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter the start position of the" + (i + 1) + "ladder:");
			int head = console.nextInt();
			System.out.println("Enter the end position of the" + (i + 1) + "ladder:");
			int tail = console.nextInt();
			b.addLadder(new Ladder(head, tail));
		}

		System.out.println("Initial Board");
		b.displayBoard();
		b.p.get(0).movePiece();

		System.out.println("Board after piece movement");
		b.displayBoard();
		b.moveSnake("UP", b.snakes[snakeHead]);

		System.out.println("Board after snake movement");
		b.displayBoard();

		console.close();
	}

}
