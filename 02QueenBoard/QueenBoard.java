public class QueenBoard {

	private int[][] board;
	private int cnt;
	private int length;

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
					ans+="Q";
				}
				else {
					ans+= "_";
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
					ans+="Q";
				}
				else {
					ans+= board[i][k];
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
				addQueens(i,k,0);
				if (cnt == length-1) {
					return true;
				}
				clearBoard();
			}
		}
		return false;
	}

	private int addQueens(int r, int c, int count) {
		if (r == c && r == length-1) {
			if (count+1 > cnt) {
				cnt = count+1;
			}
		}
		if (addQueen(r,c)) {
			if (r < length-1) {
				addQueens(r+1,c,count+1);
			}
			if (c < length-1) {
				addQueens(r,c+1,count+1);
			}
		}
		else {
			if (r < length-1) {
				addQueens(r+1,c,count);
			}
			if (c < length-1) {
				addQueens(r,c+1,count);
			}
		}
		return c;
	}

	public static void main(String[] args) {
		QueenBoard a = new QueenBoard(4);
		System.out.println(a.solve());
		System.out.println(a.cnt);
		//System.out.println(a.addQueen(1, 0));
		System.out.println(a.toString());
	}
}
