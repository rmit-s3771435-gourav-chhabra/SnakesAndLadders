package MainModules;

import graphics.*;

public class SnakeController {

	String move;
	int rowNum;
	// static Snake1 snake;

	public void moveSnake(graphics.Board b, String move, Snake1 snake) throws Exception {
		rowNum = b.snakes[snake.getHead()].getRow();
		b.snakes[snake.getHead()] = null;
		int length = snake.getLength();
		if (move.equalsIgnoreCase("UP")) {
			if (b.snakes[snake.getHead() + (2 * (10 - (snake.getHead() % 10)) + 1)] == null) {
				snake.setHead(snake.getHead() + (2 * (10 - (snake.getHead() % 10)) + 1));
				snake.setTail(snake.getHead() - length);
			} else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("DOWN")) {
			if (b.snakes[snake.getHead() - (2 * (snake.getHead() % 10)) + 1] == null) {
				snake.setHead(snake.getHead() - (2 * (snake.getHead() % 10)) + 1);
				snake.setTail(snake.getHead() - length);
			} else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("LEFT") && (rowNum % 2 == 0)) {
			if (b.snakes[snake.getHead() + 1] == null) {
				snake.setHead(snake.getHead() + 1);
				snake.setTail(snake.getHead() - length);
			} else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("LEFT") && (rowNum % 2 != 0)) {
			if (b.snakes[snake.getHead() - 1] == null) {
				snake.setHead(snake.getHead() - 1);
				snake.setTail(snake.getHead() - length);
			} else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("RIGHT") && (rowNum % 2 == 0)) {
			if (b.snakes[snake.getHead() - 1] == null) {
				snake.setHead(snake.getHead() - 1);
				snake.setTail(snake.getHead() - length);
			} else
				throw new Exception("Snake already exist at same position");
		}
		if (move.equalsIgnoreCase("RIGHT") && (rowNum % 2 != 0)) {
			if (b.snakes[snake.getHead() + 1] == null) {
				snake.setHead(snake.getHead() + 1);
				snake.setTail(snake.getHead() - length);
			} else
				throw new Exception("Snake already exist at same position");
		}
		if (snake.getHead() < 0 || snake.getHead() > 100) {
			throw new Exception("Snake head can not be outside board");
		}

		if (snake.getTail() < 0 || snake.getTail() > 100) {
			throw new Exception("Snake tail can not be outside board");
		}
		b.snakes[snake.getHead()] = snake;
	}

}
