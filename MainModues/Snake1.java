package MainModules;

public class Snake1 {
	int head, tail, length;

	public Snake1(int head, int tail) throws Exception {
		this.tail = tail;
		this.head = head;
		this.length = head - tail;
		if (length > 30) {
			throw new Exception("Snake's length cannot exceed 30.");
		}
	}

	public int getLength() {
		return (getHead() - getTail());
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) throws Exception {
		if (head > 100 || head < 1)
			throw new Exception("head can't be placed at 100 or outside board");
		this.head = head;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) throws Exception {
		if (tail <= 1)
			throw new Exception("tail can't be placed outside board");
		this.tail = tail;
	}

	public int getRow() {
		if (head <= 10) {
			return 1;
		} else if (head > 10 && head <= 20) {
			return 2;
		} else if (head > 20 && head <= 30) {
			return 3;
		} else if (head > 30 && head <= 40) {
			return 4;
		} else if (head > 40 && head <= 50) {
			return 5;
		} else if (head > 50 && head <= 60) {
			return 6;
		} else if (head > 60 && head <= 70) {
			return 7;
		} else if (head > 70 && head <= 80) {
			return 8;
		} else if (head > 80 && head <= 90) {
			return 9;
		} else if (head > 90 && head <= 100) {
			return 10;
		}
		return 0;
	}
}
