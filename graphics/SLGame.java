package graphics;

import MainModules.*;
import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class SLGame {

	// These arrays and variables are required only for part II
	Snake1 snakes[] = new Snake1[100]; // array can store up to 10 Snake objects
	Ladder ladders[] = new Ladder[100]; // array can store up to 10 Ladder objects
	Trap traps[] = new Trap[10]; // array can store up to 10 Trap objects
	String name[] = new String[4]; // array for storing the names
	int snakesCount = 0;
	int laddersCount = 0;
	int trapsCount = 0;

	// Creating a Board, dice and a Scanner objects
	Board bd = new Board();
	Dice dice = bd.getDice();
	Scanner scan = new Scanner(System.in);

	// This method creates Snakes and Ladders at fixed positions for Part A
	// Start-up code is given just to get you started
	// For Part B, modify this code to allow users to specify snake, ladder and trap
	// positions
	// You must enforce all design rules when placing snakes, ladders and traps
	// If the design rules are not violated users must re-enter values
	public void setup(Board bd) throws Exception {
		int choice = 0;
		bd.add(new Trap(25, 3));
		bd.add(new Trap(95, 3));
		trapsCount = 1;

		bd.add(new Snake1(92, 63));
		bd.add(new Snake1(62, 42));
		bd.add(new Snake1(41, 30));
		bd.add(new Snake1(77, 67));

		// snakesCount = 3;

		bd.add(new Ladder(7, 36));
		bd.add(new Ladder(55, 80));
		bd.add(new Ladder(38, 66));
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
		int numPlayers = 4;

		setup(bd); // setup method currently hard-codes the values

		bd.clearMessages(); // clears the display board

		String name1 = getString("Player 1 name : ");
		String name2 = getString("Player 2 name : ");
		String name3 = getString("Player 3 name : ");
		String name4 = getString("Player 4 name : ");
		bd.clearMessages();
		bd.addMessage("Current Players are");
		bd.addMessage("Player 1 : " + name1);
		bd.addMessage("Player 2 : " + name2);
		bd.addMessage("Player 3 : " + name3);
		bd.addMessage("Player 4 : " + name4);
		int p1Location = 1;
		int p2Location = 1;
		int p3Location = 1;
		int p4Location = 1;
		while (p1Location < 100 || p2Location < 100 || p3Location < 100 || p4Location < 100) {
			bd.setPiece(1, bd.pieces.get(0).getPos());
			bd.setPiece(2, bd.pieces.get(1).getPos());
			int val = getInt(name1 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
			if (val == 0)
				val = dice.roll();
			else
				dice.set(val);
			p1Location += val;
			// bd.pieces.get(0).movePiece(val);
			bd.setPiece(1, p1Location);
			p1Location = bd.pieces.get(0).getPos();
			plainMessage(name1 + ": moving to " + p1Location);
			bd.setPiece(1, p1Location);
			if (p1Location < 100) {
				if (bd.getLadderStart(p1Location)) {
					p1Location = bd.getLadderEnd(p1Location); // going up the first ladder
					plainMessage(name1 + ": going up a ladder to " + p1Location);
					bd.setPiece(1, p1Location);
				}
				if (bd.getSnakeHead(p1Location) && p1Location < 100) {
					p1Location = bd.getSnakeTail(p1Location); // going up the first ladder
					plainMessage(name1 + ": going down to " + p1Location);
					bd.setPiece(1, p1Location);
				}
			} else
				break;
			// here we are allowing use to set the dice value for testing purposes
			val = getInt(name2 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
			if (val == 0)
				val = dice.roll();
			else
				dice.set(val);
			p2Location += val;
			plainMessage(name2 + ": moving to " + p2Location);
			bd.setPiece(2, p2Location);
			if (p2Location < 100) {
				if (bd.getLadderStart(p2Location)) {
					p2Location = bd.getLadderEnd(p2Location); // going up the first ladder
					plainMessage(name2 + ": going up a ladder to " + p2Location);
					bd.setPiece(2, p2Location);
				}
				if (bd.getSnakeHead(p2Location) && p2Location < 100) {
					p2Location = bd.getSnakeTail(p2Location); // going up the first ladder
					plainMessage(name2 + ": going down to " + p2Location);
					bd.setPiece(2, p2Location);
				}
			}

			else
				break;
			val = getInt(name3 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
			if (val == 0)
				val = dice.roll();
			else
				dice.set(val);
			p3Location += val;
			plainMessage(name3 + ": moving to " + p3Location);
			bd.setPiece(3, p3Location);
			if (p3Location < 100) {
				if (bd.getLadderStart(p3Location)) {
					p3Location = bd.getLadderEnd(p3Location); // going up the first ladder
					plainMessage(name3 + ": going up a ladder to " + p3Location);
					bd.setPiece(3, p3Location);
				}
				if (bd.getSnakeHead(p3Location) && p3Location < 100) {
					p3Location = bd.getSnakeTail(p3Location); // going up the first ladder
					plainMessage(name3 + ": going down to " + p3Location);
					bd.setPiece(3, p3Location);
				}
			}

			else
				break;
			val = getInt(name4 + ": Enter 0 to throw dice. Enter 1 - 6 for Testing.", 0, 6);
			if (val == 0)
				val = dice.roll();
			else
				dice.set(val);
			p4Location += val;
			plainMessage(name4 + ": moving to " + p4Location);
			bd.setPiece(4, p4Location);
			if (p4Location < 100) {
				if (bd.getLadderStart(p4Location)) {
					p4Location = bd.getLadderEnd(p4Location); // going up the first ladder
					plainMessage(name4 + ": going up a ladder to " + p4Location);
					bd.setPiece(4, p4Location);
				}
				if (bd.getSnakeHead(p4Location) && p4Location < 100) {
					p4Location = bd.getSnakeTail(p4Location); // going up the first ladder
					plainMessage(name4 + ": going down to " + p4Location);
					bd.setPiece(4, p4Location);
				}
			}

			else
				break;
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

}