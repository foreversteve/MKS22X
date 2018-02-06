public class TestSum {
	public boolean testSum(int[] a, int target,int count) {
		if (target == 0) {
			return true;
		}
		if (count < a.length) {
			if (testSum(a,target-a[count],count+1)) {
				return true;
			}
			if (testSum(a,target,count+1)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		TestSum a = new TestSum();
		int[] temp = {1,3,2};
		boolean b = a.testSum(temp,8,0);
		System.out.println(b);
	}
}
