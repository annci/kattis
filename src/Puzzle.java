
public class Puzzle {
	private char[][] puzzle = new char [9][9];
	
	public Puzzle(String[] p) {
		for (int i = 0; i < 9; i++) {
			puzzle[i] = p[i].toCharArray();
		}
	}
	
	public Puzzle(char[][] p) {
		puzzle = p;
	}
	
	public Puzzle rotate() {
		char[][] rotPuzzle = new char[9][9];
		
		for(int fromRow = 0, toCol = 8; fromRow < 9; fromRow++, toCol--) {
			for (int fromCol = 0, toRow = 0; fromCol < 9; fromCol++, toRow ++) {
				rotPuzzle[toRow][toCol] = puzzle[fromRow][fromCol];
			}
		}
		return new Puzzle(rotPuzzle);
	}
	
	public Puzzle swapColumn(int col1, int col2) {
		char tmp;
		for (int row = 0; row < 9; row ++) {
			tmp = puzzle[row][col1];
			puzzle[row][col1] = puzzle[row][col2];
			puzzle[row][col2] = tmp;
		}
		return new Puzzle(puzzle);
	}
	
	public Puzzle swapRow(int row1, int row2) {
		char tmp;
		for (int col = 0; col < 9; col ++) {
			tmp = puzzle[row1][col];
			puzzle[row1][col] = puzzle[row2][col];
			puzzle[row2][col] = tmp;
		}
		return new Puzzle(puzzle);
	}
	
	public Puzzle swapRowSeg(int row1, int row2) {
		char tmp;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				tmp = puzzle[row1*3 + row][col];
				puzzle[row1*3 + row][col] = puzzle[row2*3 + row][col];
				puzzle[row2*3 + row][col] = tmp;
			}
		}
		return new Puzzle(puzzle);
	}
	
	public Puzzle swapColumnSeg(int col1, int col2) {
		char tmp;
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 9; row++) {
				tmp = puzzle[row][col1*3 + col];
				puzzle[row][col1*3 + col] = puzzle[row][col2*3 + col];
				puzzle[row][col2*3 + col] = tmp;
			}
		}
		return new Puzzle(puzzle);
	}
	
	public boolean isPerm(Puzzle p, int seg) {
		for (int i = 0; i < 6; i++) {
			if (checkSegPerm(p, seg)) {
				return true;
			}
			if (i % 2 == 0) {
				this.swapColumn(seg*3 + 1, seg*3 + 2);
			}
			else {
				this.swapColumn(seg*3, seg*3 + 2);
			}
		}
		return false;
	}
	
	public boolean checkSegPerm(Puzzle p, int seg) {
		char perm[] = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
		for (int row = 0; row < 9; row++) {
			for (int col = seg*3; col < seg*3 + 3; col++) {
				if (p.puzzle[row][col] != '0') {
					//System.out.println("puzzle[row][col] = " + puzzle[row][col]);
					//System.out.println("perm[Character.getNumericValue(p.puzzle[row][col])] = " + perm[Character.getNumericValue(p.puzzle[row][col])]);

					if (puzzle[row][col] != perm[Character.getNumericValue(p.puzzle[row][col])] && perm[Character.getNumericValue(p.puzzle[row][col])] != '0') {
						//System.out.println("false");
						return false;
					}
					else {
						perm[Character.getNumericValue(p.puzzle[row][col])] = puzzle[row][col];
					}
				}
			}
		}
		
		return true;
	}
	
	public void printPuzzle() {
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				System.out.print(puzzle[j][i]);
			}
			System.out.println();
		}
	}
}
