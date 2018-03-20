

import java.util.Arrays;

public class Merge {

	public static void mergeSort(int[] data, int start,int end) {
		if (start < end) {
			int mid = (start+end)/2;
			mergeSort(data,start,mid);
			mergeSort(data,mid+1,end);
			merge(data,start,mid,end);
		}
	}

	public static void merge(int[] data,int start, int mid, int end) {
		int[] ans = new int[data.length];
		int s1 = start;
		int s2 = mid+1;
		for (int i = start; i <= end; i++) {
			if (s1 > mid) {
				ans[i] = data[s2];
				s2+=1;
			}
			else if (s2 <= end) {
				if (data[s1] < data[s2]) {
					ans[i] = data[s1];
					s1+=1;
				}
				else {
					ans[i] = data[s2];
					s2+=1;
				}
			}
			else {
				ans[i] = data[s1];
				s1+=1;
			}
		}
		for (int i = start; i <= end; i++) {
			data[i] = ans[i];
		}
	}

	public static void main(String args[]) {
		int[] a = {-200, 2, 5, 1, -100, 7, 0, 8, 99, 7, 8};
		System.out.println(Arrays.toString(a));
		//Merge.merge(a, 0, 4, 9);
		Merge.mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
