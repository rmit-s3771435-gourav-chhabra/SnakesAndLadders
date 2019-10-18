package MainModules;

import java.util.ArrayList;
import java.util.Random;

public class Pieces {

	public int position;
	public Dice d;
	int count = 0;
	int ladderCount = 3;
	private int paralyzedState = 0;
	int snakeGuardPosition;
	int snakeGuardCount = 3;
	int numberOfMoves = 50;

	public Pieces() {
		position = 1;
		d = new Dice();
	}

	public void movePiece() {
		int moves = d.getDots();
		position += moves;
		if (moves == 6 && count < 3) {
			count++;
			movePiece();
		}
	}

	public int getPos() {
		return position;

	}

	public void movePiece(int pos) {
		this.position = pos;

	}

	public int getParalyzedState() {
		return this.paralyzedState;
	}

	public void setParalyzedState(int x) {
		this.paralyzedState = x;
	}

	public void decrementParalyzedState() {
		this.paralyzedState -= 1;
	}

	public void decrementLadderCount() {
		this.ladderCount--;
	}

	public int getLadderCount() {
		return this.ladderCount;
	}

	public void decrementSnakeGuardCount() {
		this.snakeGuardCount--;
	}

	public void setSnakeGaurdPosition() {
		this.snakeGuardPosition = this.position;
	}

	public int getSnakeGaurdPosition() {
		return this.snakeGuardPosition;
	}

	public void decrementNumberOfMoves() {
		this.numberOfMoves--;
	}

	public void movePieceDiagonal(graphics.Board b, String move) {
		ArrayList<Integer> lr = new ArrayList<Integer>();
		lr.add(1);
		lr.add(-1);
		Random rand = new Random();
		int lrDirection = lr.get(rand.nextInt(lr.size()));
		int oldPos = this.position;

		int row = (oldPos / 10) + 1;
		if (oldPos % 10 == 0) {
			row -= 1;
		}

		if (move.equalsIgnoreCase("UP")) {
			this.position = (row * 10) + (row * 10 - this.position) + 1 + lrDirection;
			if (this.position == oldPos && oldPos % 10 == 0) {
				this.position += 2;
			}
			if ((this.position - oldPos == 20) && oldPos % 10 == 1) {
				this.position -= 2;
			}
			if (this.position > 100) {
				this.position -= 2;
			}

		}
		if (move.equalsIgnoreCase("DOWN")) {
			this.position = ((row - 1) * 10) - (this.position - ((row - 1) * 10)) + 1 + lrDirection;
			if (this.position == oldPos && oldPos % 10 == 1) {
				this.position -= 2;
			}
			if ((this.position - oldPos == 20) && oldPos % 10 == 0) {
				this.position += 2;
			}
			if (this.position < 1) {
				this.position += 2;
			}
		}

		System.out.println(lrDirection);
	}

}
