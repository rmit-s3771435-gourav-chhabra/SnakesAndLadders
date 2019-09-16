package MainModules;


public class Snake {

	private int head;
	private int tail;
	private int snakeCount = 0;
	private Snake[] snakes = new Snake[4];

	public Snake(int head, int tail) throws Exception {
		this.setHead(head);
		this.setTail(tail);
		if (tail == head)
			throw new Exception("tail and head can not coincide");
		if (tail > head)
			throw new Exception("tail value must be less than head");

		snakes[snakeCount] = this;
		this.setSnakeCount();

	}

	private void setSnakeCount() throws Exception {
		if (snakeCount < 4)
			this.snakeCount++;
		else
			throw new Exception("No more snakes allowed");

	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) throws Exception {
		if (head > 100)
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

}
