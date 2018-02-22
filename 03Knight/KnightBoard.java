public class KnightBoard {
	private int[][] board;
    private int cnt;
	private final int[] inc1 = {1,-1};
	private final int[] inc2 = {2,-2};

	public KnightBoard(int startingRows,int startingCols) {
		if (startingRows < 0 || startingCols < 0 ) {
			throw new IllegalArgumentException();
		}
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
		if (!checkState()) {
			throw new IllegalStateException();
		}
		if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[0].length) {
			throw new IllegalArgumentException();
		}
		board[startingRow][startingCol] = 1;
		if (solveH(startingRow,startingCol,2)) {
			return true;
		}
		board[startingRow][startingCol] = 0;
		return false;
	}

	public int countSolutions(int startingRow, int startingCol) {
		if (!checkState()) {
			throw new IllegalStateException();
		}
		if (startingRow < 0 || startingRow >= board.length || startingCol < 0 || startingCol >= board[0].length) {
			throw new IllegalArgumentException();
		}
	    cnt = 0;
	    board[startingRow][startingCol] = 1;
	    countSolutionH(startingRow,startingCol,2);
	    board[startingRow][startingCol] = 0;
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
    public boolean checkState() {
    		for (int row = 0; row < board.length; row++) {
    			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] != 0) {
					return false;
				}
			}
    		}
    		return true;
    }
		public static void main(String[] args){
				KnightBoard a = new KnightBoard(3,3);

				System.out.println(a);
				/* Prints
					_ _ _
					_ _ _
					_ _ _
				*/

				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						if (a.solve(i,j)){
							System.out.println("There is an error with your solve method");
						}
					}
				} //prints nothing

				System.out.println(a.countSolutions(0,0)); //prints 0



				KnightBoard b = new KnightBoard(5,5);
				System.out.println(b.solve(0,0)); //prints true
				System.out.println(b); //prints a valid solution

				try{
					b.solve(0,0);
				}catch(IllegalStateException e){
					System.out.println("Error: The board contains non-zero values");
				} //prints "Error: The board contains non-zero values"

				try{
					b.countSolutions(0,0);
				}catch(IllegalStateException e){
					System.out.println("Error: The board contains non-zero values");
				} //prints "Error: The board contains non-zero values"

				try{
					KnightBoard b1 = new KnightBoard(-1,0);
				}catch(IllegalArgumentException e){
					System.out.println("Error: There cannot be negative parameters in the constructor");
				} //prints "Error: There cannot be negative parameters in the constructor"

				try{
					KnightBoard b1 = new KnightBoard(1,-1);
				}catch(IllegalArgumentException e){
					System.out.println("Error: There cannot be negative parameters in the constructor");
				} //prints "Error: There cannot be negative parameters in the constructor"

				try{
					KnightBoard b1 = new KnightBoard(-1,-1);
				}catch(IllegalArgumentException e){
					System.out.println("Error: There cannot be negative parameters in the constructor");
				} //prints "Error: There cannot be negative parameters in the constructor"

				try{
					KnightBoard b1 = new KnightBoard(5,5);
					b1.solve(0,-1);
				}catch(IllegalArgumentException e){
					System.out.println("Error: There cannot be negative parameters");
				} //prints "Error: There cannot be negative parameters"

				try{
					KnightBoard b1 = new KnightBoard(5,5);
					b1.solve(-1,0);
				}catch(IllegalArgumentException e){
					System.out.println("Error: There cannot be negative parameters");
				} //prints "Error: There cannot be negative parameters"

				try{
					KnightBoard b1 = new KnightBoard(5,5);
					b1.solve(-1,-1);
				}catch(IllegalArgumentException e){
					System.out.println("Error: There cannot be negative parameters");
				} //prints "Error: There cannot be negative parameters"



				for (int i = 0; i < 5; i++){
					for (int j = 0; j < 5; j++){
						KnightBoard abc = new KnightBoard(5,5);
						System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
					}
				}
				KnightBoard c = new KnightBoard(5,5);

				int totalSol = 0;
				for (int i = 0; i < 5; i++){
					for (int j = 0; j < 5; j++){
						totalSol += c.countSolutions(i,j);
					}
				}

				System.out.println(totalSol); //prints 1728

				KnightBoard d = new KnightBoard(5,5);
				System.out.println(d.countSolutions(0,0)); //prints 304

			}
		
}
