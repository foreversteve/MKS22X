import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Maze {

	boolean animate;

	private char[][] maze;
	int length;
	int width;

	int[] inc = {-1,1};

	public Maze(String fileName) {
		 try {

			 File text = new File(fileName);
			 Scanner inf = new Scanner(text);
			 length = 0;
			 width = 0;
			 boolean cntl = true;

			 while(inf.hasNextLine()){
				 String line = inf.nextLine();
				 length = line.length();
				 width +=1;
			 }
			 maze = new char[width][length];


			 int c = 0;
			 Scanner info = new Scanner(text);

			 while(info.hasNextLine()){
				 String line = info.nextLine();
				 for (int i = 0; i < length; i ++) {
					 maze[c][i] = line.charAt(i);

					 //System.out.println(c);
					 //System.out.println(i);

				 }
				 c+=1;
			 }

			 if (!check()) {
				 throw new IllegalStateException();
			 }

			 animate = false;
		 }
		 catch(FileNotFoundException e) {
			 System.out.println("No such file exist");

		 }
	 }

	public String toString() {
		String ans = "";
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < length; k++) {

				ans += maze[i][k];
			}
			ans += "\n";

		}
		return ans;
	}

	private boolean check() {
		int s = 0;
		int e = 0;
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < length; k++) {
				if (maze[i][k] == 'S') {
					s +=1 ;
				}
				if (maze[i][k] == 'E') {
					e +=1 ;
				}
			}
		}
		return s==1 && e== 1;

	}

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    public int solve(){

    		for (int i = 0; i < width; i++) {
			for (int k = 0; k < length; k++) {
				if (maze[i][k] == 'S') {
					maze[i][k] = '@';
					return solve(i,k,1);
				}
			}
    		}


    		return -1;
    }

    private boolean move(int row, int col) {
    		if (maze[row][col] == 'E') {
			return true;
		}

    		if (maze[row][col] != ' ' ) {
    			return false;
    		}

    		maze[row][col] = '@';
    		return true;
    }

    private void moveBack(int row,int col) {
    		if (maze[row][col] == '@') {
    			maze[row][col] = '.';
    		}
    }
    private int solve(int row, int col, int steps){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            System.out.println(steps);
            wait(20);
        }
        //COMPLETE SOLVE

        if (maze[row][col] == 'E') {
        		return steps-1;
        }
        for (int i : inc) {
        		if (move(row,col+i)) {
        			int temp = solve(row,col+i,steps+1);
        			if (temp != -1){
        				return temp;
        			}
        			moveBack(row,col+i);
        		}

        		if (move(row+i,col)) {
        			int temp = solve(row+i,col,steps+1);
        			if (temp != -1){
        				return temp;
        			}
        			moveBack(row+i,col);
        		}

        }

        	return -1; //so it compiles
    	}

    public void test() {

    }

	 public static void main(String args[]) throws FileNotFoundException {

		 Maze a = new Maze("data3.dat");
		 //System.out.println(a);
		 a.animate = true;

		 System.out.println(a.solve());
		// System.out.println(a);
		 /*System.out.println(a);
		 for (int i :a.inc) {
			 a.move(1, 1+i);
			 a.move(1+i, 1);
		 }

		 a.moveBack(1, 3);

		 System.out.println(a);
		 */


	 }

}
