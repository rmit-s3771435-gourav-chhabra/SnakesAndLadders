package graphics;

import MainModules.*;
import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class SLGame {

	// These arrays and variables are required only for part II
	// Snake1 snakes[] = new Snake1[100]; // array can store up to 10 Snake objects
	ArrayList<Snake1> snakes = new ArrayList<Snake1>();
	ArrayList<String> directions = new ArrayList<String>();
	Ladder ladders[] = new Ladder[100]; // array can store up to 10 Ladder objects
	Trap traps[] = new Trap[10]; // array can store up to 10 Trap objects
	String name[] = new String[4]; // array for storing the names
	int snakesCount = 0;
	int laddersCount = 0;
	int trapsCount = 0;

	int numPlayers = getInt("Enter number of players", 2, 4);
	// Creating a Board, dice and a Scanner objects
	Board bd = new Board(numPlayers);
	Dice dice = bd.getDice();
	SnakeController sc = new SnakeController();
	Scanner scan = new Scanner(System.in);

	// This method creates Snakes and Ladders at fixed positions for Part A
	// Start-up code is given just to get you started
	// For Part B, modify this code to allow users to specify snake, ladder and trap
	// positions
	// You must enforce all design rules when placing snakes, ladders and traps
	// If the design rules are not violated users must re-enter values
	public void setup(Board bd) throws Exception {
		// int choice = 0;
		directions.add("UP");
		directions.add("DOWN");
		directions.add("LEFT");
		directions.add("RIGHT");
		bd.add(new Trap(25, 3));
		bd.add(new Trap(95, 3));
		trapsCount = 1;

		while (true) {
			try {
				Snake1 s = new Snake1(getInt("Enter Snake 1 head", 1, 100), getInt("Enter Snake 1 tail", 1, 100));
				bd.add(s);
				snakes.add(s);
				break;
			} catch (Exception e) {
				plainMessage(e.getMessage());
				continue;
			}
		}

		while (true) {
			try {
				Snake1 s = new Snake1(getInt("Enter Snake 2 head", 1, 100), getInt("Enter Snake 2 tail", 1, 100));
				bd.add(s);
				snakes.add(s);
				break;
			} catch (Exception e) {
				plainMessage(e.getMessage());
				continue;
			}
		}

//		while (true) {
//			try {
//				Snake1 s = new Snake1(getInt("Enter Snake 3 head", 1, 100), getInt("Enter Snake 3 tail", 1, 100));
//				bd.add(s);
//				snakes.add(s);
//				break;
//			} catch (Exception e) {
//				plainMessage(e.getMessage());
//				continue;
//			}
//		}
//
//		while (true) {
//			try {
//				Snake1 s = new Snake1(getInt("Enter Snake 4 head", 1, 100), getInt("Enter Snake 4 tail", 1, 100));
//				bd.add(s);
//				snakes.add(s);
//				break;
//			} catch (Exception e) {
//				plainMessage(e.getMessage());
//				continue;
//			}
//		}
//
//		while (true) {
//			try {
//				Snake1 s = new Snake1(getInt("Enter Snake 5 head", 1, 100), getInt("Enter Snake 5 tail", 1, 100));
//				bd.add(s);
//				snakes.add(s);
//				break;
//			} catch (Exception e) {
//				plainMessage(e.getMessage());
//				continue;
//			}
//		}
		// snakesCount = 3;
		while (true) {
			try {
				bd.add(new Ladder(getInt("Enter Ladder 1 Start", 1, 100), getInt("Enter Ladder 1 End", 1, 100)));
				break;
			} catch (Exception e) {
				plainMessage(e.getMessage());
				continue;
			}
		}

		while (true) {
			try {
				bd.add(new Ladder(getInt("Enter Ladder 2 Start", 1, 100), getInt("Enter Ladder 2 End", 1, 100)));
				break;
			} catch (Exception e) {
				plainMessage(e.getMessage());
				continue;
			}
		}

//		while (true) {
//			try {
//				bd.add(new Ladder(getInt("Enter Ladder 3 Start", 1, 100), getInt("Enter Ladder 3 End", 1, 100)));
//				break;
//			} catch (Exception e) {
//				plainMessage(e.getMessage());
//				continue;
//			}
//		}
//
//		while (true) {
//			try {
//				bd.add(new Ladder(getInt("Enter Ladder 4 Start", 1, 100), getInt("Enter Ladder 4 End", 1, 100)));
//				break;
//			} catch (Exception e) {
//				plainMessage(e.getMessage());
//				continue;
//			}
//		}
//
//		while (true) {
//			try {
//				bd.add(new Ladder(getInt("Enter Ladder 5 Start", 1, 100), getInt("Enter Ladder 5 End", 1, 100)));
//				break;
//			} catch (Exception e) {
//				plainMessage(e.getMessage());
//				continue;
//			}
//		}
		// laddersCount = 3;

	}

	// A method to print a message and to read an int value in the range specified
	int getInt(String message, int from, int to) {
		String s;
		int n = 0;
		boolean invalid;
		do {
			invalid = false;
			s = (String) JOptionPane.showInputDialog(bd, message, "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
			plainMessage(message);
			try {
				n = Integer.parseInt(s);
				if (n < from || n > to)
					plainMessage("Re-enter: Input not in range " + from + " to " + to);
			} catch (NumberFormatException nfe) {
				plainMessage("Re-enter: Invalid number");
				invalid = true;
			}
		} while (invalid || n < from || n > to);
		return n;
	}

	// A method to print a message and to read a String
	String getString(String message) {
		String s = (String) JOptionPane.showInputDialog(bd, message, "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
		return s;
	}

	// A method to print a message
	void plainMessage(String message) {
		JOptionPane.showMessageDialog(bd, message, "A prompt message", JOptionPane.PLAIN_MESSAGE);
	}

	// The main method implementing the game logic for Part A
	// For Part A you may use the hard coded values in the setup() method
	// You will need to change the code for Part B
	// For user interaction use the methods getString, getInt and plainMessage
	// For display/erase on the board use bd.addMessage(), bd.clearMessages()

	public void control() throws Exception {
		// int numPlayers = 4;

		setup(bd); // setup method currently hard-codes the values

		bd.clearMessages(); // clears the display board

		String name1 = getString("Player 1 name : ");
		String name2 = getString("Player 2 name : ");
		String name3 = null;
		String name4 = null;
		bd.clearMessages();
		bd.addMessage("Current Players are");
		bd.addMessage("Player 1 : " + name1);
		bd.addMessage("Player 2 : " + name2);
		if (numPlayers > 2) {
			name3 = getString("Player 3 name : ");
			bd.addMessage("Player 3 : " + name3);
			if (numPlayers == 4) {
				name4 = getString("Player 4 name : ");
				bd.addMessage("Player 4 : " + name4);
			}
		}
		int p1Location = 1;
		int p1Count = 0;
		int p2Location = 1;
		int p2Count = 0;
		int p3Location = 1;
		int p3Count = 0;
		int p4Location = 1;
		int p4Count = 0;
		int val;
		while (p1Location < 100 || p2Location < 100 || p3Location < 100 || p4Location < 100) {
			bd.setPiece(1, bd.pieces.get(0).getPos());
			bd.setPiece(2, bd.pieces.get(1).getPos());
			if (p1Location < 100 && p1Count < 50) {
				while (true) {
					if (bd.pieces.get(0).getParalyzedState() > 0) {
						bd.pieces.get(0).decrementParalyzedState();
						break;
					}
					val = getInt(
							name1 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing Or Enter 7 to place snake guard",
							0, 7);
					if (val == 0)
						val = dice.roll();
					else
						dice.set(val);
					bd.pieces.get(0).decrementNumberOfMoves();
					p1Location += val;
					p1Count++;
					// bd.pieces.get(0).movePiece(val);
					bd.setPiece(1, p1Location);
					// p1Location = bd.pieces.get(0).getPos();
					plainMessage(name1 + ": moving to " + p1Location);
					bd.setPiece(1, p1Location);
					if (bd.getLadderStart(p1Location) && p1Location < 100) {
						p1Location = bd.getLadderEnd(p1Location); // going up the first ladder
						plainMessage(name1 + ": going up a ladder to " + p1Location);
						bd.setPiece(1, p1Location);
						bd.pieces.get(0).decrementLadderCount();
					}
					if (bd.getSnakeHead(p1Location) && p1Location < 100) {
						p1Location = bd.getSnakeTail(p1Location); // going down the snake
						plainMessage(name1 + ": going down to " + p1Location);
						bd.setPiece(1, p1Location);
						bd.pieces.get(0).setParalyzedState(3);
					}

					else

					if (val == 6 && p1Location < 100) {
						continue;
					} else
						break;
				}
				if (p1Location >= 100) {
					if (bd.pieces.get(0).getLadderCount() > 0) {
						p1Location = 1;
						bd.setPiece(1, p1Location);
					}
				}

			} else
				break;
			// here we are allowing use to set the dice value for testing purposes
			if (p2Location < 100 && p1Location < 100 && p2Count < 50) {
				while (true) {
					if (bd.pieces.get(1).getParalyzedState() > 0) {
						bd.pieces.get(1).decrementParalyzedState();
						break;
					}
					val = getInt(name2 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
					if (val == 0)
						val = dice.roll();
					else
						dice.set(val);
					bd.pieces.get(1).decrementNumberOfMoves();
					p2Location += val;
					p2Count++;
					plainMessage(name2 + ": moving to " + p2Location);
					bd.setPiece(2, p2Location);
					if (bd.getLadderStart(p2Location) && p2Location < 100) {
						p2Location = bd.getLadderEnd(p2Location); // going up the first ladder
						plainMessage(name2 + ": going up a ladder to " + p2Location);
						bd.setPiece(2, p2Location);
						bd.pieces.get(1).decrementLadderCount();
					}
					if (bd.getSnakeHead(p2Location) && p2Location < 100) {
						p2Location = bd.getSnakeTail(p2Location); // going up the first ladder
						plainMessage(name2 + ": going down to " + p2Location);
						bd.setPiece(2, p2Location);
						bd.pieces.get(1).setParalyzedState(3);
					}
					if (val == 6 && p2Location < 100) {
						continue;
					} else {
						// code to place snake guard
						val = getInt(name2 + ": Enter 0 to place snake guard", 0, 0);

						break;
					}

				}
				if (p2Location >= 100) {
					if (bd.pieces.get(1).getLadderCount() > 0) {
						p2Location = 1;
						bd.setPiece(2, p2Location);
					}
				}
			}

			else
				break;
			if (numPlayers > 2) {
				if (p3Location < 100 && p2Location < 100 && p1Location < 100 && p3Count < 50) {
					while (true) {
						if (bd.pieces.get(2).getParalyzedState() > 0) {
							bd.pieces.get(2).decrementParalyzedState();
							break;
						}
						val = getInt(name3 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
						if (val == 0)
							val = dice.roll();
						else
							dice.set(val);
						bd.pieces.get(2).decrementNumberOfMoves();
						p3Location += val;
						p3Count++;
						plainMessage(name3 + ": moving to " + p3Location);
						bd.setPiece(3, p3Location);

						if (bd.getLadderStart(p3Location) && p3Location < 100) {
							p3Location = bd.getLadderEnd(p3Location); // going up the first ladder
							plainMessage(name3 + ": going up a ladder to " + p3Location);
							bd.setPiece(3, p3Location);
							bd.pieces.get(2).decrementLadderCount();
						}
						if (bd.getSnakeHead(p3Location) && p3Location < 100) {
							p3Location = bd.getSnakeTail(p3Location); // going up the first ladder
							plainMessage(name3 + ": going down to " + p3Location);
							bd.setPiece(3, p3Location);
							bd.pieces.get(2).setParalyzedState(3);
						}
						if (val == 6 && p3Location < 100) {
							continue;
						} else
							break;
					}
					if (p3Location >= 100) {
						if (bd.pieces.get(2).getLadderCount() > 0) {
							p3Location = 1;
							bd.setPiece(3, p3Location);
						}
					}
				}

				else
					break;
			}
			if (numPlayers == 4) {
				if (p4Location < 100 && p3Location < 100 && p2Location < 100 && p1Location < 100 && p4Count < 50) {
					while (true) {
						if (bd.pieces.get(3).getParalyzedState() > 0) {
							bd.pieces.get(3).decrementParalyzedState();
							break;
						}
						val = getInt(name4 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
						if (val == 0)
							val = dice.roll();
						else
							dice.set(val);
						bd.pieces.get(3).decrementNumberOfMoves();
						p4Location += val;
						p4Count++;
						plainMessage(name4 + ": moving to " + p4Location);
						bd.setPiece(4, p4Location);
						if (bd.getLadderStart(p4Location) && p4Location < 100) {
							p4Location = bd.getLadderEnd(p4Location); // going up the first ladder
							plainMessage(name4 + ": going up a ladder to " + p4Location);
							bd.setPiece(4, p4Location);
							bd.pieces.get(3).decrementLadderCount();
						}
						if (bd.getSnakeHead(p4Location) && p4Location < 100) {
							p4Location = bd.getSnakeTail(p4Location); // going up the first ladder
							plainMessage(name4 + ": going down to " + p4Location);
							bd.setPiece(4, p4Location);
							bd.pieces.get(3).setParalyzedState(3);
						}

						if (val == 6 && p4Location < 100) {
							continue;
						} else
							break;
					}
					if (p4Location >= 100) {
						if (bd.pieces.get(3).getLadderCount() > 0) {
							p4Location = 1;
							bd.setPiece(4, p4Location);
						}
					}
				}

				else
					break;
			}

			Random rand = new Random();
			while (true) {
				try {
					Snake1 s = snakes.get(rand.nextInt(snakes.size()));
					String d = directions.get(rand.nextInt(directions.size()));

					if ((s.getHead() % 10 == 0) && d.equalsIgnoreCase("RIGHT")) {
						continue;
					}
					if ((s.getHead() % 10 == 0) && d.equalsIgnoreCase("LEFT")) {
						continue;
					}
					if ((s.getHead() % 10 == 1) && d.equalsIgnoreCase("RIGHT")) {
						continue;
					}
					if ((s.getHead() % 10 == 1) && d.equalsIgnoreCase("LEFT")) {
						continue;
					}
					if ((s.getTail() == 1) && d.equalsIgnoreCase("LEFT")) {
						continue;
					}
					if ((s.getTail() == 1) && d.equalsIgnoreCase("RIGHT")) {
						continue;
					}
					if ((s.getTail() < 10) && d.equalsIgnoreCase("DOWN")) {
						continue;
					}
					sc.moveSnake(bd, d, s);
					break;
				} catch (Exception e) {
					continue;
				}
			}
			if (bd.getSnakeHead(p1Location)) {
				p1Location = bd.getSnakeTail(p1Location);
				plainMessage(name1 + ": going down to " + p1Location);
				bd.setPiece(1, p1Location);
			}
			if (bd.getSnakeHead(p2Location)) {
				p2Location = bd.getSnakeTail(p2Location);
				plainMessage(name2 + ": going down to " + p2Location);
				bd.setPiece(2, p2Location);
			}
			if (bd.getSnakeHead(p3Location)) {
				p3Location = bd.getSnakeTail(p3Location);
				plainMessage(name3 + ": going down to " + p3Location);
				bd.setPiece(3, p3Location);
			}
			if (bd.getSnakeHead(p4Location)) {
				p4Location = bd.getSnakeTail(p4Location);
				plainMessage(name4 + ": going down to " + p4Location);
				bd.setPiece(4, p4Location);
			}
//			plainMessage("The rest is up to you. You may have to introduce additional variables.");

			// Complete the game logic
			// throwing or setting the dice
			// moving by dice value and showing the pieces at new position
			// moving up the ladder, going down the snake or being trapped (lose 3 moves)

//			bd.addMessage("Continue until");
//			bd.addMessage("a player gets to 100");
//			bd.addMessage("Remember to have fun!");
//			bd.addMessage("Danger: Traps,Snakes");
//			bd.addMessage("Trap: lose 3 moves");
		}
	}

	// The very first method to be called
	// This method constructs a SLGame object and calls its control method
	public static void main(String args[]) throws Exception {
		SLGame slg = new SLGame();

		slg.control();
	}

	// Stage 3

}