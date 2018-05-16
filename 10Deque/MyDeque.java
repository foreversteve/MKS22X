
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDeque<E>{

	private E[] data;
	private int size;

	private int first,last;

	@SuppressWarnings("unchecked")
	public MyDeque() {
		data = (E[]) new Object[10];
		size = 0;
		first = 5;
		last = 5;
	}

	@SuppressWarnings("unchecked")
	public MyDeque(int initialCapacity) {

		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}

		data = (E[]) new Object[initialCapacity];
		size = 0;
	}

	public int size() {
		return this.size;
	}
	/*
	public String toString() {

		return Arrays.toString(data);
		/*
		String ans = "[";

		for (int i = 0; i < size; i++) {
			if (first + i >= size) {
				ans += data[first+i-size]+",";
			}
			else {
				ans += data[first+i]+",";
			}
		}
		return ans.substring(0, ans.length()-1) + "]";

	}
	*/
	public String toString(){
	    String ans = "[";
	    if(first < last){
	      for (int i = first; i <= last; i++){
	        ans += data[i] + " , ";
	      }
	    }
	    else{
	      for(int i = first; i < data.length; i++){
	        ans += data[i] + ", ";
	      }
	      for(int i = 0; i <= last; i++){
	        ans += data[i] + ", ";
	      }
	    }
	    ans = ans.substring(0, ans.length() - 2) + "]";
	    return ans;
	  }

	@SuppressWarnings("unchecked")
	public void resize() {

		E[] temp = (E[]) new Object[data.length*2];
		int length = temp.length;

		for (int count = 0; count < size ; count++) {
			if (first+count < data.length) {
				temp[length/4+count] = data[first+count];
				//System.out.println(Arrays.toString(temp));
			}
			else {
				temp[length/4+count] = data[first+count-data.length];
				//System.out.println(Arrays.toString(temp));
			}
		}

		data = temp;

		first = length/4;
		last = length/4 + size -1 ;

	}

	public void addFirst(E input) {

		if (input == null) {
			throw new NullPointerException();
		}

		if (first != 0) {
			if (data[first-1] != null) {
				resize();
			}

			data[first-1] = input;

			first = first - 1;
			size+=1;

		}
		else {
			if (data[data.length-1] == null) {
				data[data.length-1] = input;

				first = data.length -1;
				size+=1;
			}
			else {
				resize();
				data[first - 1] = input;

				first = first - 1;
				size+=1;
			}
		}
	}

	public void addLast(E input) {

		if (input == null) {
			throw new NullPointerException();
		}

		if (data[(last+1) % data.length] != null) {
			resize();
			data[last+1] = input;

			last = last + 1;
			size+=1;
		}
		else {
			data[(last + 1) % data.length] = input;

			last = (last + 1) % data.length;
			size+=1;
		}
	}

	public E removeFirst() {

		if (size == 0) {
			throw new NoSuchElementException();
		}

		E temp = data[first];
		data[first] = null;

		if (first == data.length - 1) {
			first = 0;
		}
		else {
			first = first + 1;
		}
		size -= 1;

		return temp;
	}

	public E removeLast() {

		if (size == 0) {
			throw new NoSuchElementException();
		}

		E temp = data[last];
		data[last] = null;

		if (last == 0) {
			last = data.length-1;
		}
		else {
			last = last - 1;
		}
		size -= 1;

		return temp;
	}

	public E getFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[first];
	}

	public E getLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[last];
	}
	public static void main(String[] args) {
		/*
		MyDeque<Integer> a = new MyDeque<>();
		for (int i = 0 ; i < 15; i ++) {
			a.addFirst(i);
		}

		System.out.println(a);
		System.out.println(a.size);
		System.out.println(a.first);
		System.out.println(a.last);

		System.out.println();

		for (int i = -1 ; i > -15; i --) {
			a.addLast(i);
		}

		System.out.println(a);
		System.out.println(a.size);
		System.out.println(a.first);
		System.out.println(a.last);
		*/
		MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	    ArrayList<String> b = new ArrayList<>();

	    int size = Integer.parseInt("500");
	    for(int i = 0; i < size; i++){
	      int temp = (int)(Math.random() * 1000);
	      if(temp % 2 == 0){
	        a.addFirst("" + temp);
	        a1.addFirst("" + temp);
	        b.add(0, "" + temp);
	      }
	      else{
	        a.addLast("" + temp);
	        a1.addLast("" + temp);
	        b.add("" + temp);
	      }
	    }

	    int index = 0;
	    boolean hasError = false;
	    String errorEvaluation = "Errors found at these indices: ";
	    for (String x : b){
	      if (!(x.equals(a.getFirst()))){
	        System.out.println("The getFirst() function is incorrect at index " + index);
	        hasError = true;
	      }
	      if (!(x.equals(a.removeFirst()))){
	        System.out.println("There is an error at index " + index);
	        errorEvaluation += index + ", ";
	        hasError = true;
	      }
	      index++;
	    }


	    if(hasError){
	      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	      System.out.println(errorEvaluation);
	      System.out.println("MyDeque: " + a1);
	      System.out.println("Actual Deque: " + b);
	    }
	    else{
	      System.out.println("Your deque is bug-free!");
	    }


	}
}
