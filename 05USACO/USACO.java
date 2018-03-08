
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class USACO {

	static char[][] grid;
	static int[] [][] values;

	static int rowT = 0, colT= 0, time = 0;
	static int r1 = 0,c1 = 0,r2 = 0,c2 = 0;

	public static int bronze(String filename) {
		return -1;
	}
	public static String toStringg() {
		String ans="";
		for (int i=0;i<rowT;i++) {
			ans+= Arrays.deepToString(values[i]) + "\n";
		}
		return ans;
	}
    public static int silver(String filename) {
    		File file = new File(filename);
    		try {
    			Scanner sc = new Scanner(file);

    			int cnt = 0;
    			while (sc.hasNextLine()) {
    				String temp = sc.nextLine();
    				//System.out.println(temp);
    				if (cnt == 0) {
    					String arr[] = temp.split(" ");
    					rowT = Integer.parseInt(arr[0]);
    					colT = Integer.parseInt(arr[1]);
    					time = Integer.parseInt(arr[2]);
    					/*
    					rowT = Integer.parseInt(temp.substring(0,2));
    					//System.out.println(rowT);
    					colT = Integer.parseInt(temp.substring(3,5));
    					//System.out.println(colT);
    					time = Integer.parseInt(temp.substring(6,8));
    					//System.out.println(time);
    					*/
    					grid = new char[rowT][colT];
    				}
    				else {
    					if (cnt != 1 + rowT) {
    						for (int i = 0; i < colT; i ++) {
    							grid[cnt-1][i] = temp.charAt(i);
    						}
    					}
    				}
    				if (cnt == rowT+1) {
    					String arg[] = temp.split(" ");
    					r1 = Integer.parseInt(arg[0]) - 1;
    					//System.out.println(r1);
    					c1 = Integer.parseInt(arg[1]) - 1;
    					//System.out.println(c1);
    					r2 = Integer.parseInt(arg[2]) - 1;
    					//System.out.println(r2);
    					c2 = Integer.parseInt(arg[3]) - 1;
    					//System.out.println(c2);
    				}
    				cnt+=1;
    			}

    			if ((r2-r1+c2-c1)%2 != time % 2 ) {
    				return 0;
    			}

    			values = new int[rowT][colT] [time+colT];

    			values[r1][c1] [0] = 1;
    			/*
    			for (int i = 0; i < rowT; i++) {
    				for (int k = 0; k < colT; k++) {
    					for (int j = 0; j < time+colT; j++) {
    						values[i][k] [j] = -1;
    					}
    					//System.out.println((r1-i)+" "+(c1-k));
    					values[i][k] [Math.abs(r1-i) + Math.abs(c1-k)] = 1;
    				}
    			}
    			*/

    			//System.out.println(Arrays.deepToString(values));
    			return silverH();
    		}
    		catch(FileNotFoundException e) {
    			System.out.println("File not Found");
    			return -1;
    		}
    }

    public static int silverH() {
    		for (int i = 0; i < time; i++) {
    			for (int k = 0; k < rowT; k++) {
    				for (int j = 0; j < colT; j++) {

    					values[k][j] [i+1] = sumNeighbors(k,j,i);
    						//System.out.println(Arrays.deepToString(values));

    				}
    			}
    		}
    		return values[r2][c2] [time];
    }

    public static int sumNeighbors(int row, int col, int value) {
    		int[] temp = {1,-1};
    		int sum = 0;
    		for (int k : temp) {
    			try {
    				if (grid[row+k][col] != '*' ) {
    					sum += values[row+k][col] [value];
    				}
    			}
    			catch (ArrayIndexOutOfBoundsException e){

    			}
    			try {
    				if (grid[row][col+k] != '*') {
    					sum += values[row][col+k] [value];
    				}
    			}
    			catch (ArrayIndexOutOfBoundsException e){

    			}
    		}
    		return sum;
    }

    public static void main(String args[]) {
			System.out.println(USACO.silver("ctravel.1"));
			System.out.println(USACO.silver("ctravel.2"));
			System.out.println(USACO.silver("ctravel.3"));
			System.out.println(USACO.silver("ctravel.4"));
    	System.out.println(USACO.silver("ctravel.9"));
    		//System.out.println(Arrays.deepToString(USACO.values));
    		//System.out.println(USACO.toStringg());
    }
}
