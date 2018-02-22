
public class KnightBoardCopy {
	private int[][] board;
    private int cnt;
	private final int[] inc1 = {1,-1};
	private final int[] inc2 = {2,-2};

	public KnightBoardCopy(int startingRows,int startingCols) {
		board = new int[startingRows][startingCols];
		for (int i = 0; i < startingRows; i++) {
			for (int k = 0; k < startingCols; k++) {
				board[i][k] = 0;
			}
		}
		cnt = 0;
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

				}
				catch(ArrayIndexOutOfBoundsException e) {

				}
				try{
				    	if (moveKnight(row+j,col+k,level)) {
						if (solveH(row+j,col+k,level+1)) {
							return true;
						}
						moveKnightBack(row+j,col+k);
					}
				}
				catch(ArrayIndexOutOfBoundsException e){

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
	    cnt = 0;
	    board[startingRow][startingCol] = 1;
	    countSolutionH(startingRow,startingCol,2);
	    return cnt;

	}
    public void countSolutionH(int row, int col, int level){
		if (level > board.length * board[0].length) {
		    cnt+=1;
		    return;
		}
		for (int k : inc1) {
			for (int j : inc2) {
				try {
					if (moveKnight(row+k,col+j,level)) {
					    countSolutionH(row+k,col+j,level+1);



					    moveKnightBack(row+k,col+j);
					}

				}
				catch(ArrayIndexOutOfBoundsException e) {

				}
				try{
				    if (moveKnight(row+j,col+k,level)) {
					countSolutionH(row+j,col+k,level+1);

					moveKnightBack(row+j,col+k);
				    }
				}
				catch(ArrayIndexOutOfBoundsException e){

				}

			}
		}
		return;
    }
    public void generateBoard(){
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
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
		}
    }

	public static void main(String[] args) {
		KnightBoardCopy a = new KnightBoardCopy(5,5);
		//a.generateBoard();

		//a.test(2, 2);
		System.out.println(a.countSolutions(0, 0));
		//System.out.println(a.solve(0,0));
		System.out.println(a);
	}
}
