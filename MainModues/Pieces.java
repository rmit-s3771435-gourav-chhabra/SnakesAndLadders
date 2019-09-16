package MainModules;


public class Pieces {

	public int position;
	public Dice d;
	int count = 0;

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
}
