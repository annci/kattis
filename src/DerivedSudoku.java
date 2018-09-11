import java.util.ArrayList;
import java.util.Scanner;

public class DerivedSudoku {
	private static Scanner scanner;
	
	private static void check(ArrayList<Puzzle> oldPuzzles, ArrayList<Puzzle> newPuzzles) {
		int i = 0;
		for (Puzzle oldPuzzle: oldPuzzles) {
			if (checkPuzzle(oldPuzzle, newPuzzles.get(i))) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			i++;
		}
	}
	
	private static boolean checkPuzzle(Puzzle oldPuzzle, Puzzle newPuzzle) {
		for (int rotate = 0; rotate < 2; rotate++) {
			for (int rowSeg = 0; rowSeg < 6; rowSeg++) {
				for (int row0 = 0; row0 < 6; row0++) {					
				for (int row1 = 0; row1 < 6; row1++) {					
				for (int row2 = 0; row2 < 6; row2++) {
					for (int colSeg = 0; colSeg < 6; colSeg++) {
						if (oldPuzzle.isPerm(newPuzzle, 0) && oldPuzzle.isPerm(newPuzzle, 1) && oldPuzzle.isPerm(newPuzzle, 2)) {
							return true;
						}
						if (colSeg % 2 == 0) {
							oldPuzzle = oldPuzzle.swapColumnSeg(1, 2);
						}
						else {
							oldPuzzle = oldPuzzle.swapColumnSeg(0, 2);
						}
					}
					if (row2 % 2 == 0) {
						oldPuzzle = oldPuzzle.swapRow(7, 8);
					}
					else {
						oldPuzzle = oldPuzzle.swapRow(6, 8);
					}
				}
					if (row1 % 2 == 0) {
						oldPuzzle = oldPuzzle.swapRow(4, 5);
					}
					else {
						oldPuzzle = oldPuzzle.swapRow(3, 5);
					}
				}
					if (row0 % 2 == 0) {
						oldPuzzle = oldPuzzle.swapRow(1, 2);
					}
					else {
						oldPuzzle = oldPuzzle.swapRow(0, 2);
					}
				}
				if (rowSeg % 2 == 0) {
					oldPuzzle = oldPuzzle.swapRowSeg(1, 2);
				}
				else {
					oldPuzzle = oldPuzzle.swapRowSeg(0, 2);
				}
			}
			oldPuzzle = oldPuzzle.rotate();
		}
		
		return false;
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		ArrayList<Puzzle> oldPuzzles = new ArrayList<Puzzle>();
		ArrayList<Puzzle> newPuzzles = new ArrayList<Puzzle>();

		int noOfBoards = scanner.nextInt();
		String [] puzzle = new String[9];
		
		for (int j = 0; j < noOfBoards; j++) {
			scanner.nextLine();

			for (int i = 0; i < 9; i++) {
				puzzle[i] = scanner.nextLine();
			}
			oldPuzzles.add(new Puzzle(puzzle));
			
			for (int i = 0; i < 9; i++) {
				puzzle[i] = scanner.nextLine();
			}
			newPuzzles.add(new Puzzle(puzzle));
		}
		scanner.close();
		check(oldPuzzles, newPuzzles);
	}
}
