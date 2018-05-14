
import java.util.ArrayList;

public class FrontierQueue {

	private ArrayList<Location> frontier;

	public FrontierQueue() {
		frontier = new ArrayList<>();
	}

	public Location next() {
		return frontier.get(0);
	}

	public void add(Location n) {

	}

	public boolean hasNext() {
		return frontier.size() != 0;
	}
}
