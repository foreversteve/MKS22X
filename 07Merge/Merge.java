
import java.util.Random;

public class Merge {

	public static void mergesort(int[] data) {
		int[] temp = new int[data.length];
		for (int i=0; i < data.length; i++) {
			temp[i]=data[i];
		}
		msort(data,temp,0,data.length-1);
	}

	public static void msort(int[] data,int[] temp, int start, int end) {
		if (start>=end) {
			return;
		}
		int mid = (start+end)/2;
		msort(temp,data,start,mid);
		msort(temp,data,mid+1,end);

		//msort(data,temp,start,mid);
		//msort(data,temp,mid+1,end);

		merge(data,temp,start,mid,end);
	}

	public static void merge(int[] data, int[] temp, int start, int mid, int end){
		int s1 = start;
		int s2 = mid+1;
		for (int i = start; i <= end; i++) {
			//System.out.println(s1+" "+s2+" "+i);
			if (s1 > mid) {
				temp[i] = data[s2];
				s2+=1;
			}
			else if (s2 <= end) {
				if (data[s1] < data[s2]) {
					//System.out.println(Arrays.toString(temp)+" "+start+" "+ end);
					temp[i] = data[s1];
					s1+=1;
				}
				else {
					//System.out.println(Arrays.toString(temp)+" "+start+" "+ end);
					temp[i] = data[s2];
					s2+=1;
				}
			}

			else {
				//System.out.println(Arrays.toString(temp)+" "+start+" "+ end);
				temp[i] = data[s1];
				s1+=1;
			}

		}

		for (int i = start; i <= end; i++) {
			data[i] = temp[i];
		}

	}

	public static void main(String args[]) {
		int[] a = {-200, 2, 5, 1, -100, 7, 0, 8, 99, 7, 8,1000};
		int[] b = new int[10000000];
		Random c = new Random();
		for (int i = 0; i < b.length; i++) {
			b[i] = c.nextInt();
		}
		//ystem.out.println(Arrays.toString(a));
		//Merge.merge(a, 0, 4, 9);
		long startTime = System.currentTimeMillis();
		Merge.mergesort(b);
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);

		//System.out.println(Arrays.toString(a));
	}
}
