
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
		type = true;

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
		while (place < size) {
			if (type) {
				if (data[place*2+1].compareTo(data[place*2+2]) < 0) {
					if (data[place].compareTo(data[place*2+2]) < 0 ) {
						T temp = data[place];
						data[place] = data[place*2+2];
						data[place*2+2] = temp;
					}
					else {
						return;
					}
				}
				else {
					if (data[place].compareTo(data[place*2+1]) < 0 ) {
						T temp = data[place];
						data[place] = data[place*2+1];
						data[place*2+1] = temp;
					}
					else {
						return;
					}
				}
			}
			else {
				if (data[place*2+1].compareTo(data[place*2+2]) < 0) {
					if (data[place].compareTo(data[place*2+1]) > 0 ) {
						T temp = data[place];
						data[place] = data[place*2+1];
						data[place*2+1] = temp;
					}
					else {
						return;
					}
				}
				else {
					if (data[place].compareTo(data[place*2+1]) > 0 ) {
						T temp = data[place];
						data[place] = data[place*2+2];
						data[place*2+2] = temp;
					}
					else {
						return;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		MyHeap<Integer> a = new MyHeap<>();
		for (int i = 0 ; i < 25; i++) {
			a.add(i);
		}
		a.test();
		System.out.println(a);
		for (int i = 0; i < 5; i++) {
			 System.out.println(a.remove());
		}
		System.out.println(a);
	}
}
