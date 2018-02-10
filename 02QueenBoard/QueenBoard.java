public class QueenBoard {

	private int[][] board;
	private int cnt;
	private final int length;

	public QueenBoard(int size) {
		board = new int[size][size];
		length = board.length;
		clearBoard();
		cnt=0;
	}
	private boolean addQueen(int r, int c) {
		if (board[r][c] != 0) {
			return false;
		}
		board[r][c] = -1;
		for (int i = 0; i <  board.length; i++) {
			if (i != c) {
				board[r][i] +=1;
			}
		}
		for (int k = 0; k <  board.length; k++) {
			if (k != r) {
				board[k][c] +=1;
			}
		}

		helpDiagnal(r,c,1);

		return true;
	}

	public void helpDiagnal(int r, int c, int sign) {
		int l = board.length ;
		int[] inc = {1,-1};
		for (int k : inc) {
			for (int j : inc) {
				for (int i= 1; i < l; i++ ) {
					try {
						board[r+k*i][c+j*i] += sign;
					}
					catch(ArrayIndexOutOfBoundsException e) {

					}
				}
			}
		}

	}
	private boolean removeQueen(int r, int c) {
		board[r][c] = 0;

		for (int i = 0; i <  board.length; i++) {
			if (i != c) {
				board[r][i] +=-1;
			}
		}
		for (int k = 0; k <  board.length; k++) {
			if (k != r) {
				board[k][c] +=-1;
			}
		}

		helpDiagnal(r,c,-1);
		return true;
	}

	public String toString(){
		String ans = "";
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board.length; k++) {
				if (board[i][k] < 0) {
					ans+="Q ";
				}
				else {
					ans+= "_ ";
				}
			}
			ans += "\n";
		}
		return ans;
	}

	public String testToString() {
		String ans = "";
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board.length; k++) {
				if (board[i][k] < 0) {
					ans+="Q ";
				}
				else {
					ans+= board[i][k] + " ";
				}
			}
			ans += "\n";
		}
		return ans;
	}

	private void clearBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board.length; k++) {
				board[i][k] = 0;
			}
		}
	}


	 public boolean solve() {
		for (int i = 0; i < length; i++) {
			for (int k = 0; k < length; k++) {
				if (addQueens(i,k,1,i,k)) {
					System.out.println(toString());
				}
				clearBoard();
			}
		}

		return cnt == length;
	}


	private boolean checkSpace() {
		for (int i = 0; i < length; i++) {
			for (int k = 0; k < length; k++) {
				if (board[i][k] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean addQueens(int r, int c, int count,int r2, int c2) {

		if (addQueen(r,c)) {
			if (!checkSpace()) {
				if (count == length ) {
					cnt = count;
					return true;
				}
				removeQueen(r,c);
				return false;
			}

			for (int i = 0; i < length; i++) {
				for (int k = 0; k < length; k++) {
					if (board[i][k] == 0) {
						if (addQueens(i,k,count+1,r,c)) {
							return true;
						}


					}
					//addQueens(r+1,c,count+1,);
					//addQueens(r,c+1,count+1,);
				}
			}
			removeQueen(r,c);
			//return addQueens(1,0,1,1,0);
			/*
			for (int j = 0; j < length; j++) {
				for (int h = 0; h < length; h++) {
					if (board[h][j] == 0) {
						if (j != r && h != c) {
							if (addQueens(j,h,1,r2,c2)) {
								return true;
							}

						}
					}
				}
			}
			*/
		}

		/*
		else {
			for (int i = 0; i < length-r-1; i++) {
				for (int k = 0; k < length-c-1; k++) {
					if (board[i][k] == 0) {
						if (addQueens(i,k,count,r,c)) {
							return true;
						}
					}
				}
			}
		}
		*/

		return false;
	}

	public static void main(String[] args) {
		QueenBoard a = new QueenBoard(8);
		//a.addQueen(0,0);
		//a.addQueen(1, 2);
		//System.out.println(a.checkSpace());
		//System.out.println(a.testToString());
		//System.out.println(a.addQueens(0,0,1,0,0));
		a.solve();
		//System.out.println(a.cnt);
		//System.out.println(a.addQueen(1, 0));
		//System.out.println(a.toString());
	}
}
