

import java.util.ArrayList;

public class RunningMedian {

	private MyHeap<Double> front;
	private MyHeap<Double> back;

	public RunningMedian() {
		front = new MyHeap<>();
		back = new MyHeap<>(false);

		//data = new double
	}

	public void add(Double value) {
		if(back.size() == 0 && front.size() == 0){
			back.add(value);
			//System.out.println(this.toString());
		}
		else{
			if (value >  back.peek()){
				back.add(value);
		        if(back.size() - front.size() == 2){
		        		front.add(back.remove());
		        }
		    //System.out.println(this.toString());
			}
		    else {
		        front.add(value);
		        if(front.size() - back.size() == 2){
		        		back.add(front.remove());
		        }
		     	//System.out.println(this.toString());
		    }
		}
	}

	public double getMedian() {

		if (front.size() < back.size()) {
			return back.peek();
		}
		if (front.size() > back.size()) {
			return front.peek();
		}
		if (front.size() == back.size()) {
			return (front.peek()+back.peek())/2;
		}
		return 0.0;
	}

	public int size(){
		return front.size() + back.size();
	}

	public String toString() {
		return front.toString()+back.toString();
	}

	public String sizee() {
		return front.size() + " " + back.size();
	}
	public static void main(String[] args) {
		RunningMedian a = new RunningMedian();


		ArrayList<Double> test = new ArrayList<>();
		for (int i = 0 ; i < 9; i++) {
			Double temp = Math.random()*10 ;
			a.add(temp);
		//	System.out.println(a);
			test.add(temp);
		}
		test.sort(null);

		//System.out.println(a);
		//System.out.println(test);

		//System.out.println(a.size());
		System.out.println(a.getMedian());
		System.out.println(test.get(4));

	}
}
