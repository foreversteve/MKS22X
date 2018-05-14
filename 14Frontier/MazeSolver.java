
public class MazeSolver{
	  private Maze maze;
	  private Frontier frontier;

	  public MazeSolver(String mazeText){
		  maze = new Maze(mazeText);
	  }

	  //Default to BFS
	  public boolean solve(){
		 // while (! frontier.isEmpty()) {

		  //}
		  return solve(0);
	  }

	  //mode: required to allow for alternate solve modes.
	  //0: BFS
	  //1: DFS
	  public boolean solve(int mode){
		  	if(mode == 0){
		  		//frontier = new FrontierQueue();
		    }
		    else if(mode == 1){
		      frontier = new FrontierStack();
		    }
		    else if(mode == 2){
		      //frontier = new FrontierPriorityQueue();
		    }

		  	frontier.add(maze.getStart());

		  	while (frontier.hasNext()) {
		  		Location t = frontier.next();
		  		Location[] temp = maze.getNeighbors(t);
		  		for (int i = 0 ; i < temp.length; i++) {
		  			if (temp[i] == null) {
		  				break;
		  			}
		  			int x = temp[i].getX();
		  			int y = temp[i].getY();

		  			//System.out.println(x+" "+y);
		  			if (maze.get(x, y) == 'E') {
		  				Location current = temp[i];
							/*
		  				while (current.getPrev() != null) {

		  				}
							*/
		  				return true;
		  			}
		  			else {
		  				frontier.add(temp[i]);
		  				maze.set(x, y, '?');
		  				System.out.println(maze.toStringColor());
							System.out.println(temp[i].getX()+"    "+ temp[i].getY());
		  			}
		  		}

		  		if (maze.get(t.getX(),t.getY() ) != 'S') {
		  			maze.set(t.getX(),t.getY(),'.');
		  		}
		  		System.out.println(maze.toStringColor());
		  	}
	    //initialize your frontier
	    //while there is stuff in the frontier:
	    //  get the next location
	    //  process the location to find the locations (use the maze to do this)
	    //  check if any locations are the end, if you found the end just return true!
	    //  add all the locations to the frontier
	    //when there are no more values in the frontier return false
	    return false;
	  }

	  public String toString(){
	    return maze.toString();
	  }

	  public Maze getMaze() {
		  return this.maze;
	  }

	  public static void main(String[] args) {
		  MazeSolver a = new MazeSolver("data2.dat");
		  System.out.println(a.getMaze().toString());
		  System.out.println(a.solve(1));
		  System.out.println(a.getMaze().toString());

	  }

}
