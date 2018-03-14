
import java.util.Arrays;

public class Quick {

	public static int quickselect(int []data, int k){
		int p = -1;
		int start = 0, end = data.length-1;
		while (p != k) {
			int temp = partition(data,start,end);
			if (data.length-1 - start == 1) {
				return data[k];
			}
			if (temp == k) {
				return data[temp];
			}

			if (temp < k) {
				start=temp;
				p = partition(data,start,end);
			}
			else{
				end = temp;
				p = partition(data,start,end);
			}

		}
		return data[p];
	}

	public static int partition(int[] data, int start, int end) {

		int pivot = (int) (Math.random()*(end-start)+ start);

		swap(data,start,pivot);

		pivot = start;

		while(start <= end) {

			if(data[start]>data[pivot]) {
				swap(data,start,end);
				end-=1;
			}
			else {
				start+=1;
			}
		}

		swap(data,pivot,end);
		return end;
	}

	public static void swap(int[] arg,int s, int e) {
		int a = arg[e];
		arg[e] = arg[s];
		arg[s] = a;
	}
	public static void main(String arg[]) {
		int[] arr = {99,2,5,1,-100,999,0,1000,-200,8,7,1001,1002,1004};
		int[] args = {-200, 2, 5, 1, -100, 7, 0, 8, 99, 7, 8};
		//System.out.println(Quick.partition(args, 9, 10));
		System.out.println(Quick.quickselect(arr,arr.length-1));
		/*for (int i=0; i < arr.length; i++) {
			System.out.println(Quick.quickselect(arr, i));
		}
		*/

		//System.out.println(Quick.quickselect(arr, 3));
		System.out.println(Arrays.toString(arr));
	}
}
