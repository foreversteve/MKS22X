
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MyHeap <T extends Comparable<T>>{

	int size;
	boolean type;
	private T[] data;

	@SuppressWarnings("unchecked")
	public MyHeap() {
		size = 0;
		type = true;

		data = (T[])new Comparable[10];
	}

	@SuppressWarnings("unchecked")
	public MyHeap(boolean input) {
		size = 0;
		type = input;

		data = (T[])new Comparable[10];
	}

	public void add(T value) {
		if (size >= data.length) {
			resize();
		}
		data[size] = value;
		size+=1;
		moveUp();
	}

	public T remove() {
		T temp = data[0];
		data[0] = data[size-1];

		//System.out.println(this);
		data[size-1] = null;
		size -= 1;

		moveDown();
		return temp;
	}

	public T peek() {
		return data[0];
	}

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		T[] temp = (T[])new Comparable[size*2];
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public String toString() {
		return Arrays.toString(data);
	}

	private void test() {
		int place = size - 1;
		while (place > 0) {
			System.out.println(place);
			place = (place - 1) / 2;
		}
	}

	private void moveUp() {
		int place = size - 1;
		while (place >= 0) {
			if (type) {
				if (data[(place - 1) / 2].compareTo(data[place]) < 0) {
					T temp = data[place];
					data[place] = data[(place - 1) / 2];
					data[(place - 1)/ 2] = temp;
				}
				else {
					return;
				}
			}
			else{
				if (data[(place - 1) / 2].compareTo(data[place]) > 0) {
					T temp = data[place];
					data[place] = data[(place - 1) / 2];
					data[(place - 1)/ 2] = temp;
				}
				else {
					return;
				}
			}

			place = (place - 1) / 2;
		}
	}

	private void moveDown() {

		int place = 0;
		while (place*2+1 < size) {
			if (type) {
				if (place*2+2 < size && data[place*2+1].compareTo(data[place*2+2]) < 0) {
					if (data[place].compareTo(data[place*2+2]) < 0 ) {
						T temp = data[place];
						data[place] = data[place*2+2];
						data[place*2+2] = temp;

						place = place * 2 + 2;
					}
					else {
						return;
					}
				}
				else {
					if (place*2+1 < size && data[place].compareTo(data[place*2+1]) < 0 ) {
						T temp = data[place];
						data[place] = data[place*2+1];
						data[place*2+1] = temp;

						place = place*2+1;
					}
					else {
						return;
					}
				}

			}
			else {
				if (place*2 + 2 < size && data[place*2+1].compareTo(data[place*2+2]) < 0) {
					if (data[place].compareTo(data[place*2+1]) > 0 ) {
						T temp = data[place];
						data[place] = data[place*2+1];
						data[place*2+1] = temp;

						place = place * 2 + 1;
					}
					else {
						return;
					}
				}
				else {
					if (place*2+2 < size && data[place].compareTo(data[place*2+2]) > 0 ) {
						T temp = data[place];
						data[place] = data[place*2+2];
						data[place*2+2] = temp;

						place = place * 2 + 2;


					}
					else {
						return;
					}
				}
			}
		}

	}
	/*
	private void moveDown(int place) {
		T temp1 = data[place+1];
		if (place*2+1 < size) {

		}
		if (place*2+1 < size) {

		}
	}
	*/
	public static void main(String[] args) {
		/*
		MyHeap<Integer> a = new MyHeap<>(true);
		for (int i = 0 ; i < 10; i++) {
			a.add((int) (Math.random()*100));
		}
		//a.test();
		System.out.println(a);
		for (int i = 0; i < 8; i++) {
			 System.out.println(a.remove());
			 //System.out.println(a);
			 //System.out.println();
		}
		System.out.println(a);
		*/
		MyHeap<Integer> a = new MyHeap<>(false);

		ArrayList<Integer> test = new ArrayList<>();
		for (int i = 0 ; i < 100; i++) {
			int temp = (int) (Math.random()*100);
			a.add(temp);
			test.add(temp);
		}
		test.sort(null);

		//System.out.println(a);
		//System.out.println(test);

		//System.out.println();

		for (int i = 0; i < 75; i++) {
			//System.out.println(a);
			int temp1 = a.remove();
			int temp2 = test.get(0);
			test.remove(0);
			if (temp1 != temp2) {
				System.out.println("Error found");
			}
			//System.out.println(temp1 + " " + temp2);
			//System.out.println(a);
			//System.out.println(test);

			//System.out.println();
		}




	}
}
