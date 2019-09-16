package MainModules;

import java.util.ArrayList;

public class Board {
	Snake1 snakes[];
	Ladder ladders[];
//	int pieces[];
	SnakeController sc = new SnakeController();
	int count = 0;
	private int SIZE = 100;
	ArrayList<Pieces> p;

	public Board() {
		snakes = new Snake1[SIZE];
		ladders = new Ladder[SIZE];
		p = new ArrayList<Pieces>();
		addPiece();
	}

	public void addPiece() {
		for (int i = 0; i < 4; i++) {
			p.add(new Pieces());
		}

	}

	public void addSnake(Snake1 s) throws SnakePlacementException {
		if (s.getHead() >= SIZE) {
			throw new SnakePlacementException("snake head out of bounds " + s.getHead());
		} else if (snakes[s.getHead()] != null) {
			throw new SnakePlacementException("2 snakes can't be in same position " + s.getHead());
		} else if (ladders[s.getHead()] != null) {
			throw new SnakePlacementException("Head of snake can't co-incide with ladder's start point");
		}
		count = 0;
		for (int i = 0; i < snakes.length; i++) {
			if (snakes[i] != null) {
				count++;
				if(snakes[i].getHead() > 80 && s.getHead() > 80) {
					throw new SnakePlacementException("No more than 2 snakes above 81."); 
				}
			}
			if (count >= 5) {

				throw new SnakePlacementException("No more than 5 snakes allowed on board");
			}
		}
		System.out.println("Snake added to " + s.getHead());
		snakes[s.getHead()] = s;
	}

	public void addLadder(Ladder l) throws Exception {
		if (l.getEndPoint() >= SIZE) {
			throw new Exception("ladder end out of bounds " + l.getEndPoint());
		} else if (ladders[l.getEndPoint()] != null) {
			throw new Exception("2 ladders cant be in same position " + l.getEndPoint());
		} else if (snakes[l.getStartPoint()] != null) {
			throw new Exception("Head of snake can't co-incide with ladder's start point");
		} else if (snakes[l.getEndPoint()] != null) {
			throw new Exception("Head of snake can't co-incide with ladder's end point");
		}

		count = 0;
		for (int i = 0; i < ladders.length; i++) {
			if (ladders[i] != null) {
				count++;
			}
			if (count > 5) {

				throw new Exception("No more than 5 ladders allowed on board");
			}
		}
		System.out.println("Ladder added to " + l.getStartPoint());
		ladders[l.getStartPoint()] = l;
	}

	public void moveSnake(String move, Snake1 s) throws Exception {
		int previousHead = s.getHead();
		sc.moveSnake(this, move, s);
		int newPosition = s.getHead();
		if (newPosition > 80 && newPosition < 101) {
			for (int i = 81; i < 100; i++) {
				if (snakes[i] != null && i != newPosition) {
					s.setHead(previousHead);
					throw new Exception("Only one snake alowed between 81 and 100");
				}

			}
		}

	}

	public void displayBoard() {
		System.out.println("Position of pieces.");
		for (int i = 0; i < 4; i++) {
			System.out.println("Piece " + (i + 1) + ": " + p.get(i).getPos());
		}

		System.out.println("Position of Snakes.");
		count = 0;
		for (int i = 0; i < 100; i++) {
			if (snakes[i] != null) {
				System.out.println("Snake " + count++ + ": " + snakes[i].getHead() + ", " + snakes[i].getTail());
			}
		}

		System.out.println("Position of Ladders.");
		count = 0;
		for (int i = 0; i < 100; i++) {
			if (ladders[i] != null) {
				System.out.println(
						"Ladder " + count++ + ": " + ladders[i].getStartPoint() + ", " + ladders[i].getEndPoint());
			}
		}
	}

//	public void placePiece(Pieces piece, int playerNumber) {
//		int pos = piece.getPos(playerNumber);
//		p.get(playerNumber) = pos;
//	}
}
