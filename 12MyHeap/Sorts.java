

import java.util.Arrays;

public class Sorts {

	public static void heapify(Integer[] input) {
		for (int i = input.length-1; i >= 0; i--) {
			moveDown(input,i);
		}
	}

	public static void heapSort(Integer[] input) {
		heapify(input);
		for (int i = input.length-1; i >= 0; i-- ) {
			int temp = input[i];
			input[i] = input[0];
			input[0] = temp;

			//System.out.println(Arrays.toString(input));
			moveDownH(input,i);
			//System.out.println(Arrays.toString(input));
			//System.out.println();
		}

	}

	private static void moveDown(Integer[] data,int p) {

		int place = p;
		while (place*2+2 < data.length) {

			if (place*2+2 < data.length && data[place*2+1].compareTo(data[place*2+2]) < 0) {
				if (data[place].compareTo(data[place*2+2]) < 0 ) {
					Integer temp = data[place];
					data[place] = data[place*2+2];
					data[place*2+2] = temp;

					place = place * 2 + 2;
				}
				else {
					return;
				}
			}
			else {
				if (data[place].compareTo(data[place*2+1]) < 0 ) {
					Integer temp = data[place];
					data[place] = data[place*2+1];
					data[place*2+1] = temp;

					place = place*2+1;
				}
				else {
					return;
				}
			}
		}

	}

	private static void moveDownH(Integer[] data,int p) {

		int place = 0;
		while (place*2+1 < p) {

			if (place*2+2 < p && data[place*2+1].compareTo(data[place*2+2]) < 0) {
				if (data[place].compareTo(data[place*2+2]) < 0 ) {
					Integer temp = data[place];
					data[place] = data[place*2+2];
					data[place*2+2] = temp;

					place = place * 2 + 2;
				}
				else {
					return;
				}
			}
			else {
				if (data[place].compareTo(data[place*2+1]) < 0 ) {
					Integer temp = data[place];
					data[place] = data[place*2+1];
					data[place*2+1] = temp;

					place = place*2+1;
				}
				else {
					return;
				}
			}
		}

	}

	public static void main(String[] args) {
		Integer[] test = new Integer[8];
		for (int i = 0; i < 8; i++) {
			test[i] = (int) (Math.random()*100);
		}
		Sorts.heapify(test);
		System.out.println(Arrays.toString(test));

		System.out.println();

		Sorts.heapSort(test);
		System.out.println(Arrays.toString(test));

	}
}
