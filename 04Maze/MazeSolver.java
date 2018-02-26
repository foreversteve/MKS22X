import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MazeSolver {

	String[][] Maze;
	int length;
	int width;

	public MazeSolver(String fileName) {
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
			 Maze = new String[width][length];
			 int c = 0;
			 Scanner info = new Scanner(text);
			 while(info.hasNextLine()){
				 String line = info.nextLine();
				 for (int i = 0; i < length; i ++) {
					 Maze[c][i] = line.substring(i,i+1);
					 System.out.println(c);
					 System.out.println(i);

				 }
				 c+=1;
			 }
		 }
		 catch(FileNotFoundException e) {
			 System.out.println("No such file exist");
		 }
	 }

	public String toString() {
		String ans = "";
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < length; k++) {

				ans += Maze[i][k];
			}
			ans += "\n";

		}
		return ans;
	}


	 public static void main(String args[]) throws FileNotFoundException {
		 MazeSolver a = new MazeSolver("Maze1.txt");
		 System.out.println(a);
	 }

}
