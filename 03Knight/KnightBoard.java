public class KnightBoard {
	private int[][] board;
	private final int[] inc1 = {1,-1};
	private final int[] inc2 = {2,-2};

	public KnightBoard(int startingRows,int startingCols) {
		board = new int[startingRows][startingCols];
		for (int i = 0; i < startingRows; i++) {
			for (int k = 0; k < startingCols; k++) {
				board[i][k] = 0;
			}
		}
	}


	public String toString() {
		String ans = "";
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board[0].length; k++) {
				if (board[i][k] % 10 != board[i][k]) {
					ans+=" "+board[i][k];
				}
				else {
					if (board[i][k] == 0) {
						ans+="  0";
					}
					else{
						ans+= "  "+board[i][k];
					}
				}
			}
			ans += "\n";

		}
		return ans;
	}

	public boolean moveKnight(int row, int col, int move) {
		if (board[row][col] == 0) {
			board[row][col] = move;
			return true;
		}
		return false;
	}
	public boolean moveKnightBack(int row1,int col1) {
		board[row1][col1] = 0;
		return true;
	}
	private boolean solveH(int row ,int col, int level) {
		if (level > board.length * board[0].length) {
			return true;
		}
		for (int k : inc1) {
			for (int j : inc2) {
				try {
					if (moveKnight(row+k,col+j,level)) {
						if (solveH(row+k,col+j,level+1)) {
							return true;
						}
						moveKnightBack(row+k,col+j);
					}

					if (moveKnight(row+j,col+k,level)) {
						if (solveH(row+j,col+k,level+1)) {
							return true;
						}
						moveKnightBack(row+j,col+k);
					}


				}
				catch(ArrayIndexOutOfBoundsException e) {

				}

			}
		}
		return false;
	}
	public boolean solve(int startingRow, int startingCol) {
		board[startingRow][startingCol] = 1;
		return solveH(startingRow,startingCol,2);
	}

	public void test(int row,int col) {
		for (int k : inc1) {
			for (int j : inc2) {
				try {
					board[row+j][col+k] += 1;
					board[row+k][col+j] += 1;
				}
				catch(ArrayIndexOutOfBoundsException e) {

				}

			}
		}
	}
	public int countSolutions(int startingRow, int startingCol) {
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board[0].length; k++) {
				if (solve(i,k)) {
					System.out.println(this);
				}
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		KnightBoard a = new KnightBoard(6,6);
		//a.test(2, 2);
		//a.countSolutions(0, 0);
		System.out.println(a.solve(0,0));
		//System.out.println(a);
	}
}
