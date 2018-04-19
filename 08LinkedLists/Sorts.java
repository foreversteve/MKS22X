
import java.util.Random;

public class Sorts {

		public static void radixH(MyLinkedListImproved<Integer> data) {
			if(data.size <= 1 ){
				return;
			}
			int numT = Integer.toString(data.get(data.max())).length();

			@SuppressWarnings("unchecked")
			MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];

			for(int i = 0; i < 10; i ++) {
				bucket[i]= new MyLinkedListImproved<Integer>();
			}

			for (double i = 1; i <= numT; i++) {

				for (int val : data) {
					int p = (int) ((val % Math.pow(10, i) - val % Math.pow(10,i-1)) / Math.pow(10, i-1))  ;
					bucket[p].add(val);
				}

				MyLinkedListImproved<Integer> temp = new MyLinkedListImproved<>();

				for (int k = 0; k < bucket.length; k++) {
					temp.extend(bucket[k]);
				}

				data.first = temp.first;
				data.last = temp.last;
			}
		}

		public static void radixsort(MyLinkedListImproved<Integer> data) {

			MyLinkedListImproved<Integer> positive = new MyLinkedListImproved<>();
			MyLinkedListImproved<Integer> negative = new MyLinkedListImproved<>();

			if (data.size <= 1) {
				return;
			}

			for (int x : data) {
				if (x < 0) {
					negative.add(x*(-1));
				}
				else {
					positive.add(x);
				}
			}

			radixH(positive);

			MyLinkedListImproved<Integer> negativeN = new MyLinkedListImproved<>();

			if (negative.size > 1) {
				radixH(negative);
				negative.reverse();
			}
			if (negative.size == 1) {
				negativeN.add(negative.get(0)* -1);
			}
			else {
				for (int y : negative) {
					negativeN.add(y* -1);
				}
			}

			negativeN.extend(positive);

			data.clear();
			data.extend(negativeN);

		}

		public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
			radixsort(data);
		}
		public static void main(String[] args) {
			int[] test1 = {0,6,29,2001,-15};
			MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();

			int[] b = new int[1000000];
			Random c = new Random();
			for (int i = 0; i < b.length; i++) {
				b[i] = c.nextInt()%100;
			}

			for (int x : b) {
				a.add(x);
			}
			long startTime = System.currentTimeMillis();
			radixsort(a);
			long stopTime = System.currentTimeMillis();
			System.out.println(stopTime - startTime);
		}
}
