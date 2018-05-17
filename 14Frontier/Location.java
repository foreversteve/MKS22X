
public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceSoFar;

    public static Location end;

    public Location(int _x, int _y, Location prev,int distance){
    		x = _x;
    		y = _y;
    		previous = prev;
        distanceSoFar = distance;
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

    public int getDSF(){
      return distanceSoFar;
    }

    public int compareTo(Location other){
      return distance()+this.getDSF() - other.distance() - other.getDSF();
    }

    public int distance(){
      return this.getX()-end.getX() + this.getY()-end.getY();
    }




}
