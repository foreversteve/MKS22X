
public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;

    public static Location end;

    public Location(int _x, int _y, Location prev){
    		x = _x;
    		y = _y;
    		previous = prev;
    }

    public int getX() {
    		return x;
    }

    public int getY() {
    		return y;
    }

    public Location getPrev() {
    		return previous;
    }

    public int compareTo(Location other){
      return distance() - other.distance();
    }

    public int distance(){
      return this.getX()-end.getX() + this.getY()-end.getY();
    }

    public int distanceA(){
      return distance();
    }


}
