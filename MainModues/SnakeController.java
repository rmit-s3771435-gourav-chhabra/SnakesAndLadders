package MainModules;


public class SnakeController {

	String move;
	int rowNum;
	// static Snake1 snake;

	public void moveSnake(Board b, String move, Snake1 snake) throws Exception {
		rowNum = b.snakes[snake.getHead()].getRow();
		if (move.equalsIgnoreCase("UP")) {
			if (b.snakes[snake.getHead() + (2 * (10 - (snake.getHead() % 10)) + 1)] == null)
				snake.setHead(snake.getHead() + (2 * (10 - (snake.getHead() % 10)) + 1));
			else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("DOWN")) {
			if (b.snakes[snake.getHead() - (2 * (snake.getHead() % 10)) + 1] == null)
				snake.setHead(snake.getHead() - (2 * (snake.getHead() % 10)) + 1);
			else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("LEFT") && (rowNum % 2 == 0)) {
			if (b.snakes[snake.getHead() + 1] == null)
				snake.setHead(snake.getHead() + 1);
			else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("LEFT") && (rowNum % 2 != 0)) {
			if (b.snakes[snake.getHead() - 1] == null)
				snake.setHead(snake.getHead() - 1);
			else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("RIGHT") && (rowNum % 2 == 0)) {
			if (b.snakes[snake.getHead() - 1] == null)
				snake.setHead(snake.getHead() - 1);
			else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("RIGHT") && (rowNum % 2 != 0)) {
			if (b.snakes[snake.getHead() + 1] == null)
				snake.setHead(snake.getHead() + 1);
			else
				throw new Exception("Snake already exist at same position");
		}
	}

}
