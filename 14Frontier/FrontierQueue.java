
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FrontierQueue implements Frontier {

	private ArrayList<Location> frontier;

	public FrontierQueue() {
		frontier = new ArrayList<>();
	}

	public Location next() {
		if (frontier.get(0) == null){
			throw new NoSuchElementException();
		}
		return frontier.remove(0);
	}

	public void add(Location n) {
		frontier.add(n);
	}

	public boolean hasNext() {
		return frontier.size() != 0;
	}
}
