

import java.util.Arrays;
import java.util.Random;

public class Quick {


	public static void quicksort(int[] ary) {
		partition(ary,0,ary.length-1);

	}

	public static int quickselect(int []data, int k){
		int a = -1;
		int b = -1;
		int start = 0, end = data.length-1;
		while (!(k >= a && k <= b)) {
			a = partitionL(data,start,end)[0];
			b = partitionL(data,start,end)[1];
			if (k >= a && k <= b) {
				return data[k];
			}
			if (k>b) {
				start=b+1;
			}
			else{
				end = a-1;
			}

		}
		return data[k];
	}

	public static void partition(int[] data, int s, int e) {

		if (Math.abs(e-s) <= 1) {
			try {
				if(data[e] > data[s] && e < s) {
					swap(data,e,s);
				}
			}
			catch (ArrayIndexOutOfBoundsException ex) {

			}

			try {
				if(data[e] < data[s] && s < e) {
					swap(data,s,e);
				}
			}
			catch (ArrayIndexOutOfBoundsException exc) {

			}
			return;
		}

		Random a = new Random();
		int pivot = a.nextInt(e-s+1)+ s;

		int value = data[pivot];

		int start = s;
		int end = e;
		int i = start;

		while(i <= end) {

			if(data[i]<value){
				swap(data,start,i);
				start+=1;
				i+=1;

			}
			else if (data[i] == value) {
				i+=1;

			}
			else{
				swap(data,i,end);
				end-=1;

			}

		}




		partition(data,s,start-1);
		partition(data,i,e);

	}

	public static int[] partitionL(int[] data, int start, int end) {
		Random a = new Random();
		int pivot = a.nextInt(end-start+1)+ start;

		int value = data[pivot];
		int i = start;
		while(i <= end) {

			if(data[i]<value){
				swap(data,start,i);
				start+=1;
				i+=1;

			}
			else if (data[i] == value) {
				i+=1;

			}
			else{
				swap(data,i,end);
				end-=1;

			}

		}
		int[] ans = {start,end};
		return ans;
	}
	public static void swap(int[] arg,int s, int e) {
		int a = arg[e];
		arg[e] = arg[s];
		arg[s] = a;
	}
	public static void main(String arg[]) {
		int[] ary = {7,7,6,6,5,5,4,4,9,9,90,90,-1,-1};
		int[] args = {-200, 2, 5, 1, -100, 7, 0, 8, 99, 7, 8};

		Quick.quicksort(args);
		System.out.println(Arrays.toString(args));
		System.out.println(Quick.quickselect(args, 9));


	}
}
