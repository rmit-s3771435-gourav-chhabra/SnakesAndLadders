package MainModules;

import java.util.Random;

public class Dice {
	int dots, roll;
	Random number = new Random();

	public Dice() {
		dots = number.nextInt(6) + 1;
	}

	public void roll() {
		roll = number.nextInt(dots) + 1;
	}

	public int getDots() {
		roll();
		return roll;
	}

}