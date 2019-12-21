import java.util.Arrays;
import java.util.Scanner;

public class Othello {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	public static char[][] BOARD = new char[WIDTH][HEIGHT];


	public static void main(String[] args) {
		boolean turn = true; //true is white
		boolean running = true;
		
		newGame();
		printBoard();
		
		while (running) {
			printBoard();
			if (checkMove(getMove(), turn)) {			
				// register it is the next player's turn
				turn = !turn;
			}
			
			

			
		}
	}
	
	public static int getX(String move) {
		return Character.getNumericValue(move.charAt(0));
	}
	
	public static int getY(String move) {
		return Character.getNumericValue(move.charAt(1));
	}
	
	public static boolean checkMove(String move, boolean turn) {
		char turnChar;
		if (turn) {
			turnChar = 'W';
		} else {
			turnChar = 'B';
		}
		
		int x = getX(move);
		int y = getY(move);
		
		if (BOARD[x][y]==' ') {
			if (nearPiece(x,y,turn) && endOfRow(x,y,turnChar) && endOfCol(x,y,turnChar)) {
				makeMove(x,y,turnChar);
				return true;
			}
		}
		return false;
	}
	
	public static boolean endOfRow(int x, int y, char turn) {
		
	}
	
	public static boolean endOfCol(int x, int y, char turn) {
		
	}
	
	public static void makeMove(int x, int y, char piece) {
		BOARD[x][y] = piece;
	}
	
	public static boolean nearPiece(int x, int y, boolean turnBool) {
		char nextTurn;
		if (turnBool) {
			nextTurn = 'B';
		} else {
			nextTurn = 'W';
		}
		char[] neighbours = new char[4];
		neighbours[0] = BOARD[x+1][y];
		neighbours[1] = BOARD[x][y+1];
		neighbours[2] = BOARD[x-1][y];
		neighbours[3] = BOARD[x][y-1];
		
		//if next to opposite colour
		if (Arrays.asList(neighbours).contains(nextTurn)) {
			return true;
		}
		
		return false;
	}

	
	public static String getMove() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter coordinates for where to add a piece: ");
		String move = in.next();
		
		return move;
	}
	
	public static void newGame() {
		for (char[] row : BOARD) {
			for (char piece : row) {
				piece = ' ';
			}
		}
		BOARD[(WIDTH / 2) - 1][(HEIGHT / 2) - 1] = 'W';
		BOARD[(WIDTH / 2)][(HEIGHT / 2) - 1] = 'B';
		BOARD[(WIDTH / 2) - 1][(HEIGHT / 2)] = 'B';
		BOARD[(WIDTH / 2)][(HEIGHT / 2)] = 'W';
	}

	/**
	 * print the contents of the board
	 */
	public static void printBoard() {
		printRow();

		for (char[] row : BOARD) {
			System.out.print("|");
			for (char piece : row) {
				System.out.print(piece + "|");
			}
			System.out.print('\n');
			printRow();
		}
	}

	/**
	 * prints a boarder row between the cells
	 */
	public static void printRow() {
		for (int i = 0; i < WIDTH; i++) {
			System.out.print("+-");
		}
		System.out.print("+");
		System.out.print('\n');
	}
}
