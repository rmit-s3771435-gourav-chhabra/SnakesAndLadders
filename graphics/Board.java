package graphics;

import MainModules.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {
	private static JFrame frame = new JFrame("Introduction to Programming Assignment 2");
	private double factor = 0.2;
	private int XMARGIN = 20;
	private int YMARGIN = 20;
	// private int pieces[];
	private int numberOfPieces;
	private Dice dice;
	private String bLines[] = new String[8];
	private int bCount = 0;
	private Trap[] traps = new Trap[10];
	int snakesCount = 0;
	int laddersCount = 0;
	int trapsCount = 0;
	SnakeController sc = new SnakeController();
	int count = 0;
	private int SIZE = 100;
	public Snake1 snakes[] = new Snake1[SIZE];
	public Ladder ladders[] = new Ladder[SIZE];;
	public ArrayList<Pieces> pieces;

	public void addPiece() {
		for (int i = 0; i < numberOfPieces; i++) {
			pieces.add(new Pieces());
		}

	}

	public void addMessage(String line) {
		if (bCount < 8) {
			if (line.length() > 20) {
				String temp = line.substring(0, 20);
				bLines[bCount++] = temp;
			} else
				bLines[bCount++] = line;
		}

		repaint();
	}

	public void clearMessages() {
		bCount = 0;
		repaint();
	}

	Dice getDice() {
		return dice;
	}

	public void add(Snake1 s) throws SnakePlacementException {
		if (s.getHead() >= SIZE) {
			throw new SnakePlacementException("snake head out of bounds " + s.getHead());
		} else if (snakes[s.getHead()] != null) {
			throw new SnakePlacementException("2 snakes can't be in same position " + s.getHead());
		} else if (ladders[s.getHead()] != null) {
			throw new SnakePlacementException("Head of snake can't co-incide with ladder's start point");
		} else if (s.getHead() < s.getTail()) {
			throw new SnakePlacementException("Tail can not be greater than head");
		}
		count = 0;
		for (int i = 0; i < snakes.length; i++) {
			if (snakes[i] != null) {
				count++;
				if (snakes[i].getHead() > 80 && s.getHead() > 80) {
					throw new SnakePlacementException("No more than 2 snakes above 81.");
				}
			}
			if (count >= 5) {

				throw new SnakePlacementException("No more than 5 snakes allowed on board");
			}
		}
		System.out.println("Snake added to " + s.getHead());
		snakes[s.getHead()] = s;
	}

	public void add(Ladder l) throws Exception {
		if (l.getEndPoint() >= SIZE) {
			throw new Exception("ladder end out of bounds " + l.getEndPoint());
		} else if (ladders[l.getEndPoint()] != null) {
			throw new Exception("2 ladders cant be in same position " + l.getEndPoint());
		} else if (snakes[l.getStartPoint()] != null) {
			throw new Exception("Head of snake can't co-incide with ladder's start point");
		} else if (snakes[l.getEndPoint()] != null) {
			throw new Exception("Head of snake can't co-incide with ladder's end point");
		} else if (l.getEndPoint() < l.getStartPoint()) {
			throw new Exception("Start point can not be greater than end point");
		}

		count = 0;
		for (int i = 0; i < ladders.length; i++) {
			if (ladders[i] != null) {
				count++;
			}
			if (count >= 5) {

				throw new Exception("No more than 5 ladders allowed on board");
			}
		}
		System.out.println("Ladder added to " + l.getStartPoint());
		ladders[l.getStartPoint()] = l;
	}

	public void add(Trap t) {
		if (trapsCount < 10) {
			traps[trapsCount] = t;
			trapsCount++;
		}
	}

	public Board() {
		this(4);
	}

	public Board(int n) {
		if (n > 4 || n < 2) {
			System.out.println("Minimum 2 players and Maximum 4 players");
			System.exit(0);
		}
		this.numberOfPieces = n;
		pieces = new ArrayList<Pieces>();
		addPiece();

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 520);
		frame.setVisible(true);
		new Thread(this).start();
		// r.start();

//		pieces = new int[n];
//		for (int i = 0; i < n; i++)
//			pieces[i] = 1;

		dice = new Dice(this);
	}

	public void run() {
		double inc = 0.05;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			factor += inc;
			;
			if (factor > 0.5 || factor < -0.5)
				inc = -inc;
			repaint();
		}
	}

	public void drawPieces(Graphics g) {
		if (pieces.size() > 0) {
			g.setColor(Color.WHITE);
			g.fillOval((int) getX(pieces.get(0).getPos()) - 10, getY(pieces.get(0).getPos()) - 10, 20, 20);
			g.setColor(Color.BLACK);
			g.drawString("1", (int) getX(pieces.get(0).getPos()) - 5, getY(pieces.get(0).getPos()) + 5);
		}
		if (pieces.size() > 1) {
			g.setColor(Color.RED);
			g.fillOval((int) getX(pieces.get(1).getPos()) + 10, getY(pieces.get(1).getPos()) - 10, 20, 20);
			g.setColor(Color.BLACK);
			g.drawString("2", (int) getX(pieces.get(1).getPos()) + 15, getY(pieces.get(1).getPos()) + 5);
		}
		if (pieces.size() > 2) {
			g.setColor(Color.GRAY);
			g.fillOval((int) getX(pieces.get(2).getPos()) - 10, getY(pieces.get(2).getPos()) + 10, 20, 20);
			g.setColor(Color.BLACK);
			g.drawString("3", (int) getX(pieces.get(2).getPos()) - 5, getY(pieces.get(2).getPos()) + 25);
		}
		if (pieces.size() > 3) {
			g.setColor(Color.CYAN);
			g.fillOval((int) getX(pieces.get(3).getPos()) + 10, getY(pieces.get(3).getPos()) + 10, 20, 20);
			g.setColor(Color.BLACK);
			g.drawString("4", (int) getX(pieces.get(3).getPos()) + 15, getY(pieces.get(3).getPos()) + 25);
		}
	}

	public void setPiece(int piece, int pos) {
		pieces.get(piece - 1).movePiece(pos);
		// pieces[piece - 1] = pos;
		repaint();
	}

	public void drawLadder(Graphics g, int bottom, int top) {
		double x1 = getX(bottom);
		double y1 = getY(bottom);
		double x2 = getX(top);
		double y2 = getY(top);

		int steps = (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)) / 25 + 1;

		int xinc = 5;
		if (x1 > x2)
			xinc = -xinc;
		int yinc = 5;
		if (y1 > y2)
			yinc = -yinc;

		g.drawLine((int) (x1 - xinc), (int) (y1 + yinc), (int) (x2 - xinc), (int) (y2 + yinc));
		g.drawLine((int) (x1 - xinc) - 1, (int) (y1 + yinc), (int) (x2 - xinc) - 1, (int) (y2 + yinc));
		g.drawLine((int) (x1 - xinc), (int) (y1 + yinc) - 1, (int) (x2 - xinc), (int) (y2 + yinc) - 1);

		g.drawLine((int) (x1 + xinc), (int) (y1 - yinc), (int) (x2 + xinc), (int) (y2 - yinc));
		g.drawLine((int) (x1 + xinc) - 1, (int) (y1 - yinc), (int) (x2 + xinc) - 1, (int) (y2 - yinc));
		g.drawLine((int) (x1 + xinc), (int) (y1 - yinc) - 1, (int) (x2 + xinc), (int) (y2 - yinc) - 1);

		double xstep = (x2 - x1) / (steps + 1);
		double ystep = (y2 - y1) / (steps + 1);
		for (int i = 0; i < steps; i++) {
			x1 += xstep;
			y1 += ystep;
			g.drawLine((int) (x1 + xinc), (int) (y1 - yinc), (int) (x1 - xinc), (int) (y1 + yinc));
			g.drawLine((int) (x1 + xinc) - 1, (int) (y1 - yinc), (int) (x1 - xinc) - 1, (int) (y1 + yinc));
			g.drawLine((int) (x1 + xinc), (int) (y1 - yinc) - 1, (int) (x1 - xinc), (int) (y1 + yinc) - 1);
		}

	}

	private int getX(int pos) {
		pos--;
		if ((pos / 10) % 2 == 0)
			return XMARGIN + 10 + pos % 10 * 40;
		else
			return XMARGIN + 370 - pos % 10 * 40;
	}

	private int getY(int pos) {
		pos--;
		return YMARGIN - 30 + 400 - pos / 10 * 40;
	}

	public void drawSnake(Graphics g, int head, int tail) {
		int x1 = getX(head);
		int y1 = getY(head);
		int x2 = getX(tail);
		int y2 = getY(tail);

		int steps = (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)) / 150 * 18 + 24;

		double xstep = (double) (x2 - x1) / (steps + 1);
		double ystep = (double) (y2 - y1) / (steps + 1);

		double inc;
		double x = x1, y = y1;

		boolean odd = true;
		for (int i = 0; i < steps + 1; i++) {
			if ((i % 12) % 12 == 0)
				inc = 0;
			else if ((i % 12) % 11 == 0)
				inc = 10 * factor;
			else if ((i % 12) % 10 == 0)
				inc = 13 * factor;
			else if ((i % 12) % 9 == 0)
				inc = 15 * factor;
			else if ((i % 12) % 8 == 0)
				inc = 13 * factor;
			else if ((i % 12) % 7 == 0)
				inc = 10 * factor;
			else if ((i % 12) % 6 == 0)
				inc = 0 * factor;
			else if ((i % 12) % 5 == 0)
				inc = -10 * factor;
			else if ((i % 12) % 4 == 0)
				inc = -13 * factor;
			else if ((i % 12) % 3 == 0)
				inc = -15 * factor;
			else if ((i % 12) % 2 == 0)
				inc = -13 * factor;
			else
				inc = -10 * factor;
			x += xstep;
			y += ystep;
			if (odd) {
				g.setColor(Color.BLACK);
				odd = false;
			} else {
				g.setColor(Color.GREEN);
				odd = true;
			}
			if (x2 > x1)
				g.fillOval((int) (x + inc), (int) (y - inc), 20 - 10 * i / steps, 20 - 10 * i / steps);
			else
				g.fillOval((int) (x - inc), (int) (y - inc), 20 - 10 * i / steps, 20 - 10 * i / steps);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if ((i + j) % 2 == 0)
					g.setColor(Color.YELLOW);
				else
					g.setColor(Color.ORANGE);

				for (int k = 0; k < trapsCount; k++)
					g.fillRect(XMARGIN + 40 * i, YMARGIN + 40 * j, 40, 40);

			}

		}
		g.setColor(Color.BLACK);
		for (int k = 0; k < trapsCount; k++) {
			int num = traps[k].getLocation();
			if (traps[k].getDuration() == 3)
				g.setColor(Color.BLUE);
			else if (traps[k].getDuration() == 4)
				g.setColor(Color.GRAY);
			else
				g.setColor(Color.BLACK);
			g.fillRect(getX(num) - 10, getY(num) - 10, 40, 40);
		}
		g.setColor(Color.BLACK);
		for (int i = 0; i < 100; i++)
			g.drawString("" + (i + 1), getX(i + 1), getY(i + 1) + 20);
		for (int i = 0; i < snakes.length; i++) {
			if (snakes[i] != null)
				drawSnake(g, snakes[i].getHead(), snakes[i].getTail());
		}
		for (int i = 0; i < ladders.length; i++) {
			if (ladders[i] != null)
				drawLadder(g, ladders[i].getStartPoint(), ladders[i].getEndPoint());
		}

		g.setColor(Color.GRAY);
		g.fill3DRect(430, 40, 200, 340, true);

		g.setColor(Color.WHITE);
		g.fill3DRect(440, 50, 180, 320, true);
		g.setColor(Color.BLACK);
		Font font1 = new Font("TimesRoman", Font.BOLD, 16);
		g.setFont(font1);
		g.drawString("Display", 490, 20);

		for (int i = 0; i < bCount; i++)
			g.drawString(bLines[i], 450, 70 + 30 * i);

		drawPieces(g);
		dice.draw(g);
	}

	public int getLadderEnd(int startPoint) {
		return ladders[startPoint].getEndPoint();
	}

	public boolean getLadderStart(int startPoint) {
		try {
			if (ladders[startPoint] == null)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public int getSnakeTail(int head) {
		return snakes[head].getTail();
	}

	public boolean getSnakeHead(int head) {
		try {
			if (snakes[head] == null)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}