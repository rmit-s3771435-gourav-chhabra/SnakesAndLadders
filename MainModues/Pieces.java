package MainModules;

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
	
	public void decrementSnakeGuard() {
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

}
